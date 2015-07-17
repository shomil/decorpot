package com.decorpot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.decorpot.repository.models.Image;
import com.decorpot.services.DecorpotServices;

@RestController
public class DecorpotController extends DefaultController{

	@Autowired
	DecorpotServices decorpotServices;
	
	@RequestMapping(value="/test")
	public List<Image> index() {
		return decorpotServices.getImages();
	}
}
