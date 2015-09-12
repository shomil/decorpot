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
		System.out.println("decorpot-core/CartImageDetails:getGroupId()");
		return groupId;
	}


	public void setGroupId(int groupId) {
		System.out.println("decorpot-core/CartImageDetails:setGroupId()");
		this.groupId = groupId;
	}


	public String getBuyType() {
		System.out.println("decorpot-core/CartImageDetails:getGroupId()");
		return buyType;
	}


	public void setBuyType(String buyType) {
		System.out.println("decorpot-core/CartImageDetails:setBuyType()");
		this.buyType = buyType;
	}


	public String getCustText() {
		System.out.println("decorpot-core/CartImageDetails:getCustText()");
		return custText;
	}


	public void setCustText(String custText) {
		System.out.println("decorpot-core/CartImageDetails:setCustText()");
		this.custText = custText;
	}


	public int getCartId() {
		System.out.println("decorpot-core/CartImageDetails:getCartId()");
		return cartId;
	}


	public void setCartId(int cartId) {
		System.out.println("decorpot-core/CartImageDetails:setCartId()");
		this.cartId = cartId;
	}


	public double getPrice() {
		System.out.println("decorpot-core/CartImageDetails:getPrice()");
		return price;
	}


	public void setPrice(double price) {
		System.out.println("decorpot-core/CartImageDetails:setPrice()");
		this.price = price;
	}


	public String getPathSamll() {
		System.out.println("decorpot-core/CartImageDetails:getPathSamll()");
		return pathSamll;
	}


	public void setPathSamll(String pathSamll) {
		System.out.println("decorpot-core/CartImageDetails:setPathSamll()");
		this.pathSamll = pathSamll;
	}


	public String getImageTitle() {
		System.out.println("decorpot-core/CartImageDetails:getImageTitle()");
		return imageTitle;
	}


	public void setImageTitle(String imageTitle) {
		System.out.println("decorpot-core/CartImageDetails:setImageTitle()");
		this.imageTitle = imageTitle;
	}


	public enum buyType{
		onlyImage, complete;
	}
	
}
