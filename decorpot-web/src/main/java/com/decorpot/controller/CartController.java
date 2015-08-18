package com.decorpot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.decorpot.cart.models.CartAddition;

@RestController
public class CartController {
	
	@RequestMapping(value="/cart" , method = RequestMethod.POST)
	public String addToCart(@RequestBody CartAddition cartAddition, HttpServletRequest request) {
		System.out.println(cartAddition.toString());
		return "success";
	}
	
	@RequestMapping(value="/cart/{email}" , method = RequestMethod.GET)
	public String getCartDetails(@PathParam ("email") String email, HttpServletRequest request) {
		System.out.println(email);
		return "success";
	}
	
	@RequestMapping(value="/cart/{email}/{groupId}" , method = RequestMethod.DELETE)
	public String deleteFromCart(@PathParam ("email") String email, @PathParam ("groupId") int groupId, HttpServletRequest request) {
		System.out.println(email);
		return "success";
	}

}
