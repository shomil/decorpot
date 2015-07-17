package com.decorpot.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.decorpot.repositories.DatabaseList;
import com.decorpot.repositories.DecorpotRepository;
import com.decorpot.repository.models.Image;

@Service
public class DecorpotServiceImpl implements DecorpotServices{

	@Resource
	DecorpotRepository decorpotRepository;
	
	@Override
	public List<Image> getImages() {
		return decorpotRepository.getImages();
	}

}
