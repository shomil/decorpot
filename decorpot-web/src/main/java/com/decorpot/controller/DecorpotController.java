package com.decorpot.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.decorpot.repository.models.Image;
import com.decorpot.services.DecorpotServices;

@RestController
public class DecorpotController extends DefaultController{

	@Autowired
	DecorpotServices decorpotServices;
	
	@RequestMapping(value="/test")
	public List<Map<String, Object>> index() {
		return decorpotServices.getDataBaseTables();
	}
	
	@RequestMapping(value="/imageList/{space}")
	public List<Map<String, Object>> getImageListSpace(@QueryParam("from") int fromPrice,
			@QueryParam("to") int toPrice,
			@QueryParam("page") Integer pageNum,
			@PathParam("space") String space) {
		return decorpotServices.getImageListSpace(space, toPrice, fromPrice, pageNum);
	}
}
