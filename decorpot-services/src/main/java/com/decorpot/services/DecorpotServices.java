package com.decorpot.services;

import java.util.List;
import java.util.Map;

import com.decorpot.repositories.DatabaseList;
import com.decorpot.repository.models.Image;

public interface DecorpotServices {
	public List<Map<String, Object>> getDataBaseTables();
	public List<Map<String, Object>> getimageList();
}
