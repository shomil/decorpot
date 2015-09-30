package com.decorpot.services;

import java.util.List;
import java.util.Map;

import com.decorpot.repositories.DatabaseList;
import com.decorpot.repository.models.Image;
import com.decorpot.repository.models.ImageDetail;
import com.decorpot.repository.models.ImageGroup;

public interface DecorpotServices {
	public List<Map<String, Object>> getDataBaseTables();
	public List<ImageDetail> getImageListSpace(String space, Integer toPrice, Integer fromPrice, Integer pageNum);
	public List<Map<String, Object>> getImageListTheme(String space, Integer toPrice, Integer fromPrice, Integer pageNum);
	public List<Map<String, Object>> getViewsByColors(String color, int groupid);
	public List<Map<String, Object>> getColorsByGroup(int groupid);
	public List<Map<String, Object>> getViewsByGroup(int groupid);
	public ImageGroup getImageGroupDetails(int groupId);
	public List<Map<String, Object>> getPriceDetailByGroupId(int groupId);
}
