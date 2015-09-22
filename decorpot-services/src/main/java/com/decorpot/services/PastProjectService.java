package com.decorpot.services;

import java.util.List;
import java.util.Map;

public interface PastProjectService {
	public List<Map<String, Object>> getAllProjects();
	public List<Map<String, Object>> getImagesByAppartment(String project);
}
