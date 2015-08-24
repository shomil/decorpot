package com.decorpot.cart.models;

public class CartImageDetails {
	
	private int cartId;
	private int groupId;
	private String buyType;
	private String custText;
	private double price;
	private String pathSamll;
	private String imageTitle;
	
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


	public String getPathSamll() {
		return pathSamll;
	}


	public void setPathSamll(String pathSamll) {
		this.pathSamll = pathSamll;
	}


	public String getImageTitle() {
		return imageTitle;
	}


	public void setImageTitle(String imageTitle) {
		this.imageTitle = imageTitle;
	}


	public enum buyType{
		onlyImage, complete;
	}
	
}
