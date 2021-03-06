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
import com.decorpot.utils.DecorpotConstants;

@Service
public class ApartmentServiceImpl implements ApartmentService {

	@Autowired
	private ApartmentRepo apartmentRepo;

	@Override
	public List<Map<String, Object>> getAllApartment(String apartmentName) {
		final String key = "getAllApartment" + apartmentName;
		System.out.println(apartmentName);
		List<Map<String, Object>> apartments = null;
		if (DataCache.getInstance().get(key) == null) {
			if (apartmentName.equals("all")) {
				apartments = apartmentRepo.getAllApartment();
			} else {
				apartments = apartmentRepo.getAllApartmentByName(apartmentName);
			}

			for (Map<String, Object> apartment : apartments) {
				apartment.put("image_id", DecorpotConstants.S3_BUCKET+DecorpotConstants.IMAGE_910X521
						+ apartment.get("image_id").toString() + ".jpg");
			}
			DataCache.getInstance().put(key, apartments);
		} else {
			apartments = (List<Map<String, Object>>) DataCache.getInstance()
					.get(key);
		}
		return apartments;
	}

	@Override
	public Apartment getApartment(String aprtId) {
		final String key = "getApartment" + aprtId;
		List<Map<String, Object>> groups = null;
		Apartment apartment = null;
		String[] params = aprtId.split("-");
		if (DataCache.getInstance().get(key) == null) {
			groups = apartmentRepo.getApartment(params[0]);
			double totalPrice = 0.0;
			apartment = new Apartment();
			List<ImageGroup> imageGroups = new ArrayList<>();

			for (Map<String, Object> group : groups) {
				System.out.println(group);
				ImageGroup ig = new ImageGroup();
				ig.setBasePrice(((Integer) group.get("IMAGE_PRICE")).intValue());
				ig.setGroupId((int) group.get("group_id"));
				ig.setImageDescription((String) group.get("IMAGE_DESCRIPTION"));
				ig.setImageSpace((String) group.get("image_space"));
				ig.setImageTitle((String) group.get("IMAGE_TITLE"));
				ig.setBasePriceDescription((String) group
						.get("BASEPRICE_DESCRIPTION"));
				imageGroups.add(ig);
				totalPrice += ig.getBasePrice();
			}
			apartment.setGroups(imageGroups);
			apartment.setTotalPrice(totalPrice);
			apartment.setApartmentName((String) groups.get(0).get(
					"apartment_name"));
			apartment.setAprtId((Integer) groups.get(0).get("aprt_group"));
			apartment.setBhk((String) groups.get(0).get("bhk"));
			DataCache.getInstance().put(key, apartment);
		} else {
			apartment = (Apartment) DataCache.getInstance().get(key);
		}
		return apartment;
	}

	@Override
	public List<Map<String, Object>> getAllApartment() {
		final String key = "getAllApartment";
		List<Map<String, Object>> apartments = null;
		if (DataCache.getInstance().get(key) == null) {

			apartments = apartmentRepo.getAllApartment();

			for (Map<String, Object> apartment : apartments) {
				apartment.put("image_id", DecorpotConstants.S3_BUCKET+DecorpotConstants.IMAGE_910X521
						+ apartment.get("image_id").toString() + ".jpg");
			}
			DataCache.getInstance().put(key, apartments);
		} else {
			apartments = (List<Map<String, Object>>) DataCache.getInstance()
					.get(key);
		}
		return apartments;
	}

}
