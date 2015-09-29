package com.decorpot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.decorpot.repository.models.Apartment;
import com.decorpot.services.ApartmentService;

@RestController
@RequestMapping("/apartments")
public class ApartmentController {
	
	@Autowired
	private ApartmentService apartmentService;
	
	@RequestMapping( method = RequestMethod.GET)
	public List<Map<String, Object>> getAllApartment( HttpServletRequest request){
		return apartmentService.getAllApartment();
	}
	
	@RequestMapping(value="/{aprtId}", method = RequestMethod.GET)
	public Apartment getApartment(@PathParam("aprtId") String aprtId, HttpServletRequest request){
		return apartmentService.getApartment(Integer.parseInt(aprtId));
	}

}
