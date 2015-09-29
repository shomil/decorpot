package com.decorpot.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decorpot.cache.DataCache;
import com.decorpot.repository.interfaces.ApartmentRepo;

@Service
public class ApartmentServiceImpl implements ApartmentService {

	@Autowired
	private ApartmentRepo apartmentRepo;

	private final String mediumImageUrl = "https://s3-ap-southeast-1.amazonaws.com/decorpot/image_lot_medium/";

	@Override
	public List<Map<String, Object>> getAllApartment() {
		final String key = "getAllApartment";
		List<Map<String, Object>> apartments = null;
		if (DataCache.getInstance().get(key) == null) {
			apartments = apartmentRepo.getAllApartment();
			for (Map<String, Object> apartment : apartments) {
				apartment.put("image_id",
						mediumImageUrl + apartment.get("image_id").toString()
								+ ".jpg");
			}
			DataCache.getInstance().put(key, apartments);
		}else{
			apartments = (List<Map<String, Object>>) DataCache.getInstance().get(key);
		}
		return apartments;
	}

}
