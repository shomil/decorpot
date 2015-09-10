package com.decorpot.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.decorpot.repository.models.ImageDetail;
import com.decorpot.services.DecorpotServices;

@EnableWebMvc
@RestController
public class DecorpotController extends DefaultController{

	@Autowired
	DecorpotServices decorpotServices;
	
	@RequestMapping(value="/test")
	public List<Map<String, Object>> index() {
		return decorpotServices.getDataBaseTables();
	}
		
	@RequestMapping(value="imageListSpace/{space}", method = RequestMethod.GET, headers="Accept=*/*", produces="application/json")
	public List<ImageDetail> getImageListSpace(@PathVariable String space,
			@QueryParam("from") int from,
			@QueryParam("to") int to,
			@QueryParam("page") Integer page
			
			) {
		long start = System.currentTimeMillis();
		List<ImageDetail> images = decorpotServices.getImageListSpace(space, to, from, page);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		return images;
	}
	
	
	@RequestMapping(value="image/group/{groupid}/color/{color}", headers="Accept=*/*", method = RequestMethod.GET, produces="application/json")
	public List<Map<String, Object>> getViewsByColors(@PathVariable int groupid,
			@PathVariable String color
			) {
		long start = System.currentTimeMillis();
		List<Map<String, Object>> views = decorpotServices.getViewsByColors(color, groupid);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		return views;
	}
	
	@RequestMapping(value="color/{groupid}", method = RequestMethod.GET, headers="Accept=*/*", produces="application/json")
	public List<Map<String, Object>> getColorsByGroup(@PathVariable int groupid){
		long start = System.currentTimeMillis();
		List<Map<String, Object>> colors = decorpotServices.getColorsByGroup(groupid);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		return colors;
		
	}
}
