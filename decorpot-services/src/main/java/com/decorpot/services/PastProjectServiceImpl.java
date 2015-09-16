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
	
	@Override
	public List<String> getAllProjects() {
		return pastProjectRepo.getAllProjects();
	}

	@Override
	public List<Map<String, Object>> getImagesByAppartment(String project) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> images = pastProjectRepo.getImagesByAppartment(project.replaceAll("-", " "));
		for(Map<String, Object> image : images){
			image.put("SMALL_PATH", smallImageUrl + image.get("SMALL_PATH").toString());
			image.put("HD_PATH", hdImageUrl + image.get("HD_PATH").toString());
		}
		return images;
	}
}
