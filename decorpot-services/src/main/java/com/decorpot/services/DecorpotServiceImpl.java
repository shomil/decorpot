package com.decorpot.services;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decorpot.repositories.DatabaseList;
import com.decorpot.repositories.DecorpotRepository;
import com.decorpot.repository.interfaces.ImageList;
import com.decorpot.repository.models.Image;

@Service
public class DecorpotServiceImpl implements DecorpotServices{

	private int defaultList = 10;
	private String smallImageUrl = "https://s3-ap-southeast-1.amazonaws.com/decorpot/low_image/";
	@Resource
	DecorpotRepository decorpotRepository;
	
	@Autowired 
	ImageList imageList;
	
	@Override
	public List<Map<String, Object>> getDataBaseTables() {
		return decorpotRepository.getDatabaseName();
	}

	@Override
	public List<Map<String, Object>> getImageListSpace(String space, Integer toPrice, Integer fromPrice, Integer pageNum) {
		
		int to=pageNum*this.defaultList, from=(pageNum-1)*this.defaultList+1;
		System.out.println("services/com.decorpot.services/DecorpotServiceImpl.getImageListSpace");
		
		 List<Map<String, Object>> images = imageList.getImageListSpace( space, toPrice, fromPrice, to, from);
		 
		 for(Map<String, Object> image : images){
			 image.put("path_small", smallImageUrl+image.get("path_small").toString());
		 }
		 return images;
	}

	@Override
	public List<Map<String, Object>> getViewsByColors(String color, int groupid) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> images =  imageList.getViewsByColors(color, groupid);
		for(Map<String, Object> image : images){
			 image.put("path_small", smallImageUrl+image.get("path_small").toString());
			 image.put("path_hd", smallImageUrl+image.get("path_hd").toString());
		 }
		 return images;
		
	}

	@Override
	public List<Map<String, Object>> getColorsByGroup(int groupid) {
		// TODO Auto-generated method stub
		return imageList.getColorsByGroup(groupid);
	}

	@Override
	public List<Map<String, Object>> getImageListTheme(String theme, Integer toPrice, Integer fromPrice,
			Integer pageNum) {
		System.out.println("services/com.decorpot.services/DecorpotServiceImpl.getImageListTheme");
		int to=pageNum*this.defaultList, from=(pageNum-1)*this.defaultList+1;
		List<Map<String,Object>> images = imageList.getImageListTheme(theme, toPrice, fromPrice, to, from);
		for(Map<String, Object> image : images){
			 image.put("path_small", smallImageUrl+image.get("path_small").toString());
		 }
		 return images;
	}

	
}
