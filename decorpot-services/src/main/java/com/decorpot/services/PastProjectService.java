package com.decorpot.services;

import java.util.List;
import java.util.Map;

public interface PastProjectService {
	public List<String> getAllProjects();
	public List<Map<String, Object>> getImagesByAppartment(String project);
}
