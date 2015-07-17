package com.decorpot.services;

import java.util.List;

import com.decorpot.repositories.DatabaseList;
import com.decorpot.repository.models.Image;

public interface DecorpotServices {
	public List<Image> getImages();
}
