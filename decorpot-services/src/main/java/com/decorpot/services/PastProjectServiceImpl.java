package com.decorpot.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decorpot.repository.interfaces.PastProjectsRepo;

@Service
public class PastProjectServiceImpl implements PastProjectService {

	@Autowired
	private PastProjectsRepo pastProjectRepo;
	private final String smallImageUrl =  "https://s3-ap-southeast-1.amazonaws.com/decorpot/work_done_low/";
	private final String hdImageUrl =  "https://s3-ap-southeast-1.amazonaws.com/decorpot/work_done_hd/";
	private final String mediumImageUrl = "https://s3-ap-southeast-1.amazonaws.com/decorpot/work_done_medium/";
	
	@Override
	public List<Map<String, Object>> getAllProjects() {
		List<Map<String, Object>> projects = pastProjectRepo.getAllProjects();
		for(Map<String, Object> project : projects){
			project.put("SMALL_PATH", smallImageUrl + project.get("SMALL_PATH").toString());
			project.put("MEDIUM_PATH", mediumImageUrl + project.get("MEDIUM_PATH").toString());
		}
		return projects;
	}

	@Override
	public List<Map<String, Object>> getImagesByAppartment(String project) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> images = pastProjectRepo.getImagesByAppartment(project.replaceAll("-", " "));
		for(Map<String, Object> image : images){
			image.put("SMALL_PATH", smallImageUrl + image.get("SMALL_PATH").toString());
			image.put("HD_PATH", mediumImageUrl + image.get("HD_PATH").toString());
		}
		return images;
	}
}
