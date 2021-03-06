package com.decorpot.repository.interfaces;

import java.util.List;
import java.util.Map;

public interface ApartmentRepo {
	
	public List<Map<String, Object>> getAllApartment();
	
	public List<Map<String, Object>> getAllApartmentByName(String apartmentName);
	
	public List<Map<String, Object>> getApartment(String aprtId);

}
