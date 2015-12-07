package com.decorpot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.decorpot.services.ProjectsService;

@EnableWebMvc
@RestController
@RequestMapping("/projects")
public class ProjectsController {
	
	@Autowired
	private ProjectsService pastProjectService;
	
	@RequestMapping(value="/completed", method = RequestMethod.GET)
	public List<Map<String, Object>> getAllProjects(){
		return pastProjectService.getAllProjects();
	}
	
	@RequestMapping(value="/completed/{project}", method = RequestMethod.GET)
	public List<Map<String, Object>> getImagesByAppartment(@PathVariable String project) {
		return pastProjectService.getImagesByAppartment(project);
	}
	
	@RequestMapping(value="/ongoing", method = RequestMethod.GET)
	public List<Map<String, Object>> getAllOngoingProjects(){
		return pastProjectService.getAllOngoingProjects();
	}
	
	@RequestMapping(value="/ongoing/{project}", method = RequestMethod.GET)
	public List<Map<String, Object>> getOngoingProjectByApartment(@PathVariable String project) {
		return pastProjectService.getOngoingProjectByApartment(project);
	}

}
