package com.decorpot.repository.interfaces;

import java.util.List;
import java.util.Map;

import com.decorpot.repository.models.Image;

public interface ImageList {
	public List<Map<String, Object>> getImageListSpace(String space,
			Integer toPrice, Integer fromPrice, Integer to, Integer from);
	public List<Map<String, Object>> getImageListTheme(String theme, 
			Integer toPrice, Integer fromPrice, Integer to, Integer from);
	
	public List<Map<String, Object>> getImageListSpace(int groupId);
	
	public List<Map<String, Object>> getViewsByColors(String color, int groupid);
	
	public List<Map<String, Object>> getColorsByGroup(int groupid);

}
