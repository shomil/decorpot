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
import com.decorpot.repository.models.ImageDetail;

@Service
public class DecorpotServiceImpl implements DecorpotServices{

	private int defaultList = 10;
	//private String smallImageUrl = "https://s3-ap-southeast-1.amazonaws.com/decorpot/low_image/";
	private String smallImageUrl =  "https://s3-ap-southeast-1.amazonaws.com/decorpot/image_lot_small/";
	private String largeImageUrl =  "https://s3-ap-southeast-1.amazonaws.com/decorpot/image_lot_large/";
	@Resource
	DecorpotRepository decorpotRepository;
	
	@Autowired 
	ImageList imageList;
	
	@Override
	public List<Map<String, Object>> getDataBaseTables() {
		System.out.println("decorpot-services/DecorpotServiceImpl:getDataBaseTables");
		return decorpotRepository.getDatabaseName();
	}

	@Override
	public List<ImageDetail> getImageListSpace(String space, Integer toPrice, Integer fromPrice, Integer pageNum) {
		System.out.println("decorpot-services/DecorpotServiceImpl:getImageListSpace");
		int to=pageNum*this.defaultList, from=(pageNum-1)*this.defaultList+1;
		System.out.println("to= "+to+" and from= "+from);
		
		List<ImageDetail> images = imageList.getImageListSpace( space, toPrice, fromPrice, to, from);
		 
		 for(ImageDetail image : images){
			 image.setPathSmall(smallImageUrl+image.getPathSmall());
		 }
		 System.out.println("Images Returned");
		 return images;
	}

	@Override
	public List<Map<String, Object>> getViewsByColors(String color, int groupid) {
		System.out.println("decorpot-services/DecorpotServiceImpl:getViewsByColors()");
		List<Map<String, Object>> images =  imageList.getViewsByColors(color, groupid);
		for(Map<String, Object> image : images){
			 image.put("PATH_SMALL", smallImageUrl+image.get("PATH_SMALL").toString());
			 image.put("PATH_HD", largeImageUrl+image.get("PATH_HD").toString());
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
			 image.put("PATH_SMALL", smallImageUrl+image.get("PATH_SMALL").toString());
		 }
		 return images;
	}

	@Override
	public List<Map<String, Object>> getViewsByGroup(int groupid) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> images = imageList.getViewsByGroup(groupid);
		for(Map<String, Object> image : images){
			 image.put("PATH_SMALL", smallImageUrl+image.get("PATH_SMALL").toString());
			 image.put("PATH_HD", largeImageUrl+image.get("PATH_HD").toString());
		 }
		 return images;
	}
	
}
