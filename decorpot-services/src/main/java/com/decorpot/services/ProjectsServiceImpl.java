package com.decorpot.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decorpot.cache.DataCache;
import com.decorpot.repository.interfaces.ProjectsRepo;
import com.decorpot.utils.DecorpotConstants;

@Service
public class ProjectsServiceImpl implements ProjectsService {

	@Autowired
	private ProjectsRepo pastProjectRepo;
	private final String smallImageUrl = DecorpotConstants.S3_BUCKET+DecorpotConstants.WORK_DONE_BY_US_LOW;
	private final String hdImageUrl = DecorpotConstants.S3_BUCKET+DecorpotConstants.WORK_DONE_BY_US_HD;
	private final String mediumImageUrl = DecorpotConstants.S3_BUCKET+DecorpotConstants.WORK_DONE_BY_US_MEDIUM;

	@Override
	public List<Map<String, Object>> getAllProjects() {
		String key = "getAllPastProjects";
		List<Map<String, Object>> projects = null;
		if (DataCache.getInstance().get(key) == null) {
			projects = pastProjectRepo.getAllProjects();
			for (Map<String, Object> project : projects) {
				project.put("SMALL_PATH",
						smallImageUrl + project.get("SMALL_PATH").toString());
				project.put("MEDIUM_PATH",
						mediumImageUrl + project.get("MEDIUM_PATH").toString());
			}
			DataCache.getInstance().put(key, projects);
		}else{
			projects = (List<Map<String, Object>>) DataCache.getInstance().get(key);
		}
		return projects;
	}

	@Override
	public List<Map<String, Object>> getImagesByAppartment(String project) {
		String key = "getImagesByAppartment" + project;
		System.out.println(key);
		List<Map<String, Object>> images = null;
		if (DataCache.getInstance().get(key) == null) {
			images = pastProjectRepo.getImagesByAppartment(project.replaceAll(
					"-", " "));
			for (Map<String, Object> image : images) {
				image.put("SMALL_PATH", smallImageUrl
						+ image.get("SMALL_PATH").toString());
				image.put("HD_PATH", mediumImageUrl
						+ image.get("HD_PATH").toString());
			}
			DataCache.getInstance().put(key, images);
		} else {
			System.out.println("getting from cache");
			images = (List<Map<String, Object>>) DataCache.getInstance().get(
					key);
		}
		return images;
	}

	@Override
	public List<Map<String, Object>> getAllOngoingProjects() {
		String key = "getAllOngoingProjects";
		List<Map<String, Object>> projects = null;
		if (DataCache.getInstance().get(key) == null) {
			projects = pastProjectRepo.getAllProjects();
			for (Map<String, Object> project : projects) {
				project.put("SMALL_PATH",
						smallImageUrl + project.get("SMALL_PATH").toString());
				project.put("MEDIUM_PATH",
						mediumImageUrl + project.get("MEDIUM_PATH").toString());
			}
			DataCache.getInstance().put(key, projects);
		}else{
			projects = (List<Map<String, Object>>) DataCache.getInstance().get(key);
		}
		return projects;
	}

	@Override
	public List<Map<String, Object>> getOngoingProjectByApartment(String project) {
		String key = "getOngoingProjectByApartment" + project;
		System.out.println(key);
		List<Map<String, Object>> images = null;
		if (DataCache.getInstance().get(key) == null) {
			images = pastProjectRepo.getImagesByAppartment(project.replaceAll(
					"-", " "));
			for (Map<String, Object> image : images) {
				image.put("SMALL_PATH", smallImageUrl
						+ image.get("SMALL_PATH").toString());
				image.put("HD_PATH", mediumImageUrl
						+ image.get("HD_PATH").toString());
			}
			DataCache.getInstance().put(key, images);
		} else {
			System.out.println("getting from cache");
			images = (List<Map<String, Object>>) DataCache.getInstance().get(
					key);
		}
		return images;
	}
}
