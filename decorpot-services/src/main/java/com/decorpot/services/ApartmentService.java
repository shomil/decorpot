package com.decorpot.services;

import java.util.List;
import java.util.Map;

import com.decorpot.repository.models.Apartment;

public interface ApartmentService {
	public List<Map<String, Object>> getAllApartment();
	public Apartment getApartment(String aprtId);

}
