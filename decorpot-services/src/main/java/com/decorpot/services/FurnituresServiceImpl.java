package com.decorpot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decorpot.cache.DataCache;
import com.decorpot.repository.interfaces.FurnituresRepo;
import com.decorpot.rest.models.Furniture;
import com.decorpot.rest.models.Furnitures;

@Service
public class FurnituresServiceImpl implements FurnituresService {
	
	@Autowired
	private FurnituresRepo furnituresRepo;

	@Override
	public Furnitures getAllFurnitures() {
		String key = "getAllFurnitures";
		Furnitures furnitures = null;
		if (DataCache.getInstance().get(key) == null) {
			furnitures.setFurnitures(furnituresRepo.getAllFurnitures());
			DataCache.getInstance().put(key, furnitures);
		}else{
			furnitures = (Furnitures) DataCache.getInstance().get(key);
		}
		return furnitures;
	}

	@Override
	public Furnitures getAllFurnituresByType(String type) {
		
		String key = "getAllFurnituresByType" + type;
		Furnitures furnitures = null;
		if (DataCache.getInstance().get(key) == null) {
			furnitures.setFurnitures(furnituresRepo.getAllFurnituresByType(type));
			DataCache.getInstance().put(key, furnitures);
		}else{
			furnitures = (Furnitures) DataCache.getInstance().get(key);
		}
		return furnitures;
	}

	@Override
	public Furniture getFurnitureById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
