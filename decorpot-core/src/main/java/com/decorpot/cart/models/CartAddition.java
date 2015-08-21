package com.decorpot.cart.models;

import java.util.List;

public class CartAddition {
	
	private String email;
	private String name;
	private List<CartImageDetails> cartImageDetails;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CartImageDetails> getCartImageDetails() {
		return cartImageDetails;
	}
	public void setCartImageDetails(List<CartImageDetails> cartImageDetails) {
		this.cartImageDetails = cartImageDetails;
	}
	
	

}
