package com.decorpot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.decorpot.rest.models.Furniture;
import com.decorpot.rest.models.Furnitures;
import com.decorpot.services.FurnituresService;

@EnableWebMvc
@RestController
@RequestMapping("/furnitures")
public class FurnituresController {
	
	@Autowired
	private FurnituresService furnituresService;
	
	
	public Furnitures getAllFurnitures(){
		return furnituresService.getAllFurnitures();
		
	}
	
	@RequestMapping(value="/{type}")
	public Furnitures getAllFurnituresByType(@PathVariable String  type){
		return furnituresService.getAllFurnituresByType(type);
		
	}
	
	@RequestMapping(value="/{id}")
	public Furniture getFurnitureById(@PathVariable int id){
		return furnituresService.getFurnitureById(id);
		
	}

}
