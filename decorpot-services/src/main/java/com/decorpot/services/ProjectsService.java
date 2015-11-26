package com.decorpot.services;

import java.util.List;
import java.util.Map;

public interface ProjectsService {
	public List<Map<String, Object>> getAllProjects();
	public List<Map<String, Object>> getImagesByAppartment(String project);
	
	public List<Map<String, Object>> getAllOngoingProjects();
	public List<Map<String, Object>> getOngoingProjectByApartment(String project);
}
