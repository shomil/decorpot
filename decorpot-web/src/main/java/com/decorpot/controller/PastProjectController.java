package com.decorpot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.decorpot.services.PastProjectService;

@RestController
@RequestMapping("/project")
public class PastProjectController {
	
	@Autowired
	private PastProjectService pastProjectService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Map<String, Object>> getAllProjects(){
		return pastProjectService.getAllProjects();
	}
	
	@RequestMapping(value="/{project}", method = RequestMethod.GET)
	public List<Map<String, Object>> getImagesByAppartment(@PathVariable String project) {
		return pastProjectService.getImagesByAppartment(project);
	}

}
