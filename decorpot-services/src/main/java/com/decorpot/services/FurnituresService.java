package com.decorpot.services;

import com.decorpot.rest.models.Furniture;
import com.decorpot.rest.models.Furnitures;

public interface FurnituresService {
	
	public Furnitures getAllFurnitures();
	public Furnitures getAllFurnituresByType(String type);
	public Furniture getFurnitureById(int id);

}
