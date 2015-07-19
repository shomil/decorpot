package com.decorpot.repository.interfaces;

import java.util.List;
import java.util.Map;

import com.decorpot.repository.models.Image;

public interface ImageList {
	public List<Map<String, Object>> getImageListing(String theme);

}
