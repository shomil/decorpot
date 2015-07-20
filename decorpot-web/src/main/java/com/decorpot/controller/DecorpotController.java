package com.decorpot.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.decorpot.services.DecorpotServices;

@RestController
public class DecorpotController extends DefaultController{

	@Autowired
	DecorpotServices decorpotServices;
	
	@RequestMapping(value="/test")
	public List<Map<String, Object>> index() {
		return decorpotServices.getDataBaseTables();
	}
	
	@RequestMapping(value="imageListSpace/{space}")
	public List<Map<String, Object>> getImageListSpace(@PathVariable String space,
			@QueryParam("from") int from,
			@QueryParam("to") int to,
			@QueryParam("page") Integer page
			
			) {
		return decorpotServices.getImageListSpace(space, to, from, page);
	}
}
