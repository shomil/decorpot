package com.decorpot.cart.models;

import java.util.Arrays;

public class CartAddition {
	
	private String email;
	private String name;
	private CartImageDetails [] cartImageDetails;
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
	public CartImageDetails [] getCartImageDetails() {
		return cartImageDetails;
	}
	public void setCartImageDetails(CartImageDetails [] cartImageDetails) {
		this.cartImageDetails = cartImageDetails;
	}
	@Override
	public String toString() {
		return "CartAddition [email=" + email + ", name=" + name
				+ ", cartImageDetails=" + Arrays.toString(cartImageDetails)
				+ "]";
	}
	

}
