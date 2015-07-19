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
	private int defaultPageNum = 1;
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
		
		
		return imageList.getImageListSpace( space, toPrice, fromPrice, to, from);
	}

}
