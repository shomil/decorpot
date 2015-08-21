package com.decorpot.cart.models;

import java.util.List;

public class CartDetails {
	
	private double totalPrice;
	private List<CartImageDetails> imageDetails;
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<CartImageDetails> getImageDetails() {
		return imageDetails;
	}
	public void setImageDetails(List<CartImageDetails> imageDetails) {
		this.imageDetails = imageDetails;
	} 

}
