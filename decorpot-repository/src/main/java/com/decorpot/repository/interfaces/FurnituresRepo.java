package com.decorpot.repository.interfaces;

import java.util.List;

import com.decorpot.rest.models.Furniture;
import com.decorpot.rest.models.Furnitures;

public interface FurnituresRepo {
	
	public List<Furniture> getAllFurnitures();
	public List<Furniture> getAllFurnituresByType(String type);
	public Furniture getFurnitureById(int id);

}
