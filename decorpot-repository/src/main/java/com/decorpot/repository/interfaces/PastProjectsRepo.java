package com.decorpot.repository.interfaces;

import java.util.List;
import java.util.Map;

public interface PastProjectsRepo {
	
	public List<Map<String, Object>> getAllProjects();
	public List<Map<String, Object>> getImagesByAppartment(String project);

}
