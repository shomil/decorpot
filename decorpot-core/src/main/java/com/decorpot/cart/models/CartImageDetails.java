package com.decorpot.cart.models;

public class CartImageDetails {
	
	private int cartId;
	private int groupId;
	private String buyType;
	private String custText;
	private double price;
	
	public int getGroupId() {
		return groupId;
	}


	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}


	public String getBuyType() {
		return buyType;
	}


	public void setBuyType(String buyType) {
		this.buyType = buyType;
	}


	public String getCustText() {
		return custText;
	}


	public void setCustText(String custText) {
		this.custText = custText;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public enum buyType{
		onlyImage, complete;
	}
	
}
