package com.decorpot.controller;

import static com.decorpot.controller.Constants.AUTH_CODE;
import static com.decorpot.controller.Constants.CLIENT_ID_KEY;
import static com.decorpot.controller.Constants.CLIENT_SECRET;
import static com.decorpot.controller.Constants.CODE_KEY;
import static com.decorpot.controller.Constants.CS_FACEBOOK;
import static com.decorpot.controller.Constants.CS_GOOGLE;
import static com.decorpot.controller.Constants.GRANT_TYPE_KEY;
import static com.decorpot.controller.Constants.REDIRECT_URI_KEY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.decorpot.repository.core.UserRepository;

@RestController
@RequestMapping(value = "/auth")
public class AuthController extends DefaultController {

	private final String USER_AGENT = "Mozilla/5.0";
	public static final ObjectMapper MAPPER = new ObjectMapper();

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "facebook", method = RequestMethod.POST)
	public String loginWithFacebook(@RequestBody Payload payload)
			throws URISyntaxException {

		final String accessTokenUrl = "https://graph.facebook.com/v2.3/oauth/access_token";

		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		nameValuePairs.add(new BasicNameValuePair(GRANT_TYPE_KEY, AUTH_CODE));
		nameValuePairs.add(new BasicNameValuePair(CLIENT_ID_KEY, payload
				.getClientId()));
		nameValuePairs.add(new BasicNameValuePair(CLIENT_SECRET, CS_FACEBOOK));
		nameValuePairs.add(new BasicNameValuePair(REDIRECT_URI_KEY, payload
				.getRedirectUri()));
		nameValuePairs.add(new BasicNameValuePair(CODE_KEY, payload.getCode()));

		String result = "{}";

		String tokenExchange = get(accessTokenUrl, nameValuePairs);
		Map<String, String> responseJson = new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode obj;

		try {
			//System.out.println("tokenExchange => " + tokenExchange);
			responseJson = mapper.readValue(tokenExchange,
					new TypeReference<HashMap<String, String>>() {
					});

			List<NameValuePair> queryParameters = new ArrayList<NameValuePair>(
					1);
			queryParameters.add(new BasicNameValuePair("expires_in", "json"));
			queryParameters.add(new BasicNameValuePair("access_token",
					responseJson.get("access_token")));
			queryParameters.add(new BasicNameValuePair("token_type", "Bearer"));
			queryParameters.add(new BasicNameValuePair("fields",
					"id,email,name"));

			String googleUserInfo = getFBUserProfileAndUpdate(queryParameters);
			obj = mapper.createObjectNode();
			obj.put("credentials", mapper.readTree(tokenExchange));
			JsonNode user = mapper.readTree(googleUserInfo);
			obj.put("user", user);

			Map<String, Object> userMap = mapper.convertValue(user, Map.class);
			
			System.out.println(userRepository.addUser(userMap));
			
			result = mapper.writeValueAsString(obj);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	@RequestMapping(value = "google", method = RequestMethod.POST)
	public String loginWithGoogle(@RequestBody Payload payload)
			throws IOException {

		final String accessTokenUrl = "https://accounts.google.com/o/oauth2/token";

		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		nameValuePairs.add(new BasicNameValuePair(GRANT_TYPE_KEY, AUTH_CODE));
		nameValuePairs.add(new BasicNameValuePair(CLIENT_ID_KEY, payload
				.getClientId()));
		nameValuePairs.add(new BasicNameValuePair(CLIENT_SECRET, CS_GOOGLE));
		nameValuePairs.add(new BasicNameValuePair(REDIRECT_URI_KEY, payload
				.getRedirectUri()));
		nameValuePairs.add(new BasicNameValuePair(CODE_KEY, payload.getCode()));

		String tokenExchange = post(accessTokenUrl, nameValuePairs);

		String result = "{}";

		Map<String, String> responseJson = new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode obj;
		try {
			responseJson = mapper.readValue(tokenExchange,
					new TypeReference<HashMap<String, String>>() {
					});
			String googleUserInfo = getGoogleUserProfileAndUpdate(responseJson
					.get("access_token"));
			obj = mapper.createObjectNode();
			obj.put("credentials", mapper.readTree(tokenExchange));
			JsonNode user = mapper.readTree(googleUserInfo);
			obj.put("user", user);

			Map<String, Object> userMap = mapper.convertValue(user, Map.class);
			
			System.out.println(userRepository.addUser(userMap));
			
			result = mapper.writeValueAsString(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//

		return result;
	}

	private String getGoogleUserProfileAndUpdate(String accessToken)
			throws URISyntaxException {
		final String profileUrl = "https://www.googleapis.com/oauth2/v1/userinfo";
		List<NameValuePair> queryParameters = new ArrayList<NameValuePair>(1);
		queryParameters.add(new BasicNameValuePair("alt", "json"));
		queryParameters
				.add(new BasicNameValuePair("access_token", accessToken));

		return get(profileUrl, queryParameters);
	}

	private String getFBUserProfileAndUpdate(List<NameValuePair> queryParameters)
			throws URISyntaxException {
		final String profileUrl = "https://graph.facebook.com/v2.3/me";
		return get(profileUrl, queryParameters);
	}

	private String post(String url, List<NameValuePair> parameters) {
		StringBuffer result = new StringBuffer();

		try (CloseableHttpClient httpClient = HttpClientBuilder.create()
				.build()) {

			HttpPost postRequest = new HttpPost(url);
			postRequest.setHeader("User-Agent", USER_AGENT);
			postRequest.setEntity(new UrlEncodedFormEntity(parameters));

			HttpResponse response = httpClient.execute(postRequest);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));

			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return result.toString();
	}

	private String get(String url, List<NameValuePair> parameters)
			throws URISyntaxException {
		StringBuffer result = new StringBuffer();

		try (CloseableHttpClient httpClient = HttpClientBuilder.create()
				.build()) {

			URI uri = new URIBuilder(url).addParameters(parameters).build();
			//System.out.println("uri => " + uri);
			HttpGet getRequest = new HttpGet(uri);
			getRequest.setHeader("User-Agent", USER_AGENT);

			HttpResponse response = httpClient.execute(getRequest);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));

			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return result.toString();
	}

	public static class Payload {

		String clientId;

		String redirectUri;

		String code;

		public String getClientId() {
			return clientId;
		}

		public String getRedirectUri() {
			return redirectUri;
		}

		public String getCode() {
			return code;
		}
	}
}
