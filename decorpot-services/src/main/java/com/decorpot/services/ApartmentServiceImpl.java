package com.decorpot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decorpot.cache.DataCache;
import com.decorpot.repository.interfaces.ApartmentRepo;
import com.decorpot.repository.models.Apartment;
import com.decorpot.repository.models.ImageGroup;

@Service
public class ApartmentServiceImpl implements ApartmentService {

	@Autowired
	private ApartmentRepo apartmentRepo;

	private final String smallImageUrl = "https://s3-ap-southeast-1.amazonaws.com/decorpot/image_lot_small/";

	@Override
	public List<Map<String, Object>> getAllApartment() {
		final String key = "getAllApartment";
		List<Map<String, Object>> apartments = null;
		if (DataCache.getInstance().get(key) == null) {
			apartments = apartmentRepo.getAllApartment();
			for (Map<String, Object> apartment : apartments) {
				apartment.put("image_id",
						smallImageUrl + apartment.get("image_id").toString()
								+ ".jpg");
			}
			DataCache.getInstance().put(key, apartments);
		}else{
			apartments = (List<Map<String, Object>>) DataCache.getInstance().get(key);
		}
		return apartments;
	}

	@Override
	public Apartment getApartment(int aprtId) {
		final String key = "getApartment" + aprtId;
		List<Map<String, Object>> groups = null;
		Apartment apartment = null;
		if(DataCache.getInstance().get(key) == null){
			groups = apartmentRepo.getApartment(aprtId);
			double totalPrice = 0.0;
			apartment = new Apartment();
			List<ImageGroup> imageGroups = new ArrayList<>();
			apartment.setAprtId(aprtId);
			for(Map<String, Object> group : groups){
				ImageGroup ig = new ImageGroup();
				ig.setBasePrice(((Double) group.get("IMAGE_PRICE")).doubleValue());
				ig.setGroupId(((Integer) group.get("group_id")).intValue());
				ig.setImageDescription((String) group.get("IMAGE_DESCRIPTION"));
				ig.setImageSpace((String) group.get("image_space"));
				imageGroups.add(ig);
				totalPrice += ig.getBasePrice();
			}
			apartment.setGroups(imageGroups);
			apartment.setTotalPrice(totalPrice);
			apartment.setApartmentName((String) groups.get(0).get("apartment_name"));
			apartment.setBhk((String) groups.get(0).get("bhk"));
			DataCache.getInstance().put(key, apartment);
		}else{
			apartment = (Apartment) DataCache.getInstance().get(key);
		}
		return apartment;
	}

}
