package com.decorpot.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.decorpot.repositories.DatabaseList;
import com.decorpot.repositories.DecorpotRepository;

@Service
public class DecorpotServiceImpl implements DecorpotServices{

	@Resource
	DecorpotRepository decorpotRepository;
	
	@Override
	public List<DatabaseList> getImages() {
		return decorpotRepository.getImages();
	}

}
