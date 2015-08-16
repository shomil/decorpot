package com.decorpot.controller;

import static com.decorpot.controller.Constants.AUTH_CODE;
import static com.decorpot.controller.Constants.CLIENT_ID_KEY;
import static com.decorpot.controller.Constants.CLIENT_SECRET;
import static com.decorpot.controller.Constants.CODE_KEY;
import static com.decorpot.controller.Constants.CS_GOOGLE;
import static com.decorpot.controller.Constants.GRANT_TYPE_KEY;
import static com.decorpot.controller.Constants.REDIRECT_URI_KEY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.decorpot.auth.AuthUtils;

@RestController
@RequestMapping(value = "/auth")
public class AuthController extends DefaultController {

	private final String USER_AGENT = "Mozilla/5.0";
	public static final ObjectMapper MAPPER = new ObjectMapper();

	@RequestMapping(value = "facebook")
	public String loginWithFacebook(@QueryParam("code") String authorizationCode) {
		return authorizationCode;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "google", method = RequestMethod.POST)
	public String loginWithGoogle(@RequestBody Payload payload)
			throws  IOException {

		final String accessTokenUrl = "https://accounts.google.com/o/oauth2/token";
		final String peopleApiUrl = "https://www.googleapis.com/plus/v1/people/me/openIdConnect";

		// Step 1. Exchange authorization code for access token.
		final MultivaluedMap<String, String> accessData = new MultivaluedHashMap<String, String>();
		accessData.add(CLIENT_ID_KEY, payload.getClientId());
		accessData.add(REDIRECT_URI_KEY, payload.getRedirectUri());
		accessData.add(CLIENT_SECRET, CS_GOOGLE);
		accessData.add(CODE_KEY, payload.getCode());
		accessData.add(GRANT_TYPE_KEY, AUTH_CODE);

		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		nameValuePairs.add(new BasicNameValuePair(GRANT_TYPE_KEY, AUTH_CODE));
		nameValuePairs.add(new BasicNameValuePair(CLIENT_ID_KEY, payload
				.getClientId()));
		nameValuePairs.add(new BasicNameValuePair(CLIENT_SECRET, CS_GOOGLE));
		nameValuePairs.add(new BasicNameValuePair(REDIRECT_URI_KEY, payload
				.getRedirectUri()));
		nameValuePairs.add(new BasicNameValuePair(CODE_KEY, payload.getCode()));

		StringBuffer result = new StringBuffer();
		StringBuffer result2 = new StringBuffer();
		
		try (CloseableHttpClient httpClient = HttpClientBuilder.create()
				.build()) {

			HttpPost postRequest = new HttpPost(accessTokenUrl);
			postRequest.setHeader("User-Agent", USER_AGENT);
			postRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse response = httpClient.execute(postRequest);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));

			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			System.out.println(result);
				
			Map<String, String> map = new HashMap<String, String>();
			ObjectMapper mapper = new ObjectMapper();
			JsonNode tree = mapper.readTree(result.toString());
			map = mapper.readValue(result.toString(), HashMap.class);
			
			HttpGet getRequest = new HttpGet(peopleApiUrl);
			getRequest.addHeader(AuthUtils.AUTH_HEADER_KEY, String.format("Bearer %s", map.get("access_token")));
			getRequest.setHeader("User-Agent", USER_AGENT);
			
			response = httpClient.execute(postRequest);
			rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));

			line = "";
			while ((line = rd.readLine()) != null) {
				result2.append(line);
			}
			System.out.printf("PROFILE ==========================> %s", result2);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		/*response = client.target(accessTokenUrl).request()
				.post(Entity.form(accessData));
		accessData.clear();

		// Step 2. Retrieve profile information about the current user. final
		String accessToken = (String) getResponseEntity(response).get(
				"access_token");
		response = client
				.target(peopleApiUrl)
				.request("text/plain")
				.header(AuthUtils.AUTH_HEADER_KEY,
						String.format("Bearer %s", accessToken)).get();*/

		

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
