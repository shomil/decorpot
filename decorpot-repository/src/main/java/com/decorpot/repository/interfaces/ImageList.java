package com.decorpot.repository.interfaces;

import java.util.List;
import java.util.Map;

import com.decorpot.repository.core.ImagesByGroup;
import com.decorpot.repository.models.Image;
import com.decorpot.repository.models.ImageDetail;
import com.decorpot.repository.models.ImageGroup;

public interface ImageList {
	public List<ImageDetail> getImageListSpace(String space,
			Integer toPrice, Integer fromPrice, Integer to, Integer from);
	public List<Map<String, Object>> getImageListTheme(String theme, 
			Integer toPrice, Integer fromPrice, Integer to, Integer from);
	
	public List<ImageDetail> getImageListSpace(int groupId);
	
	
	public List<Map<String, Object>> getViewsByColors(String color, int groupid);
	
	public List<Map<String, Object>> getColorsByGroup(int groupid);
	
	public List<ImagesByGroup> getAllImages();
	
	public List<Map<String, Object>> getViewsByGroup(int groupid);
	
	public ImageGroup getImageGroupDetails(int groupId);
	
	public List<Map<String, Object>> getPriceDetailByGroupId(int groupId);
	

}
