package com.decorpot.cart.models;


public class CartAddition {
	
	private String email;
	private String name;
	private int groupId;
	private String buyType;
	private String custText;
	private boolean isCustomized = false;
	
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
	public enum buyType{
		onlyImage, complete;
	}
	
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
	public boolean isCustomized() {
		return isCustomized;
	}
	public void setCustomized(boolean isCustomized) {
		this.isCustomized = isCustomized;
	}
	@Override
	public String toString() {
		return "CartAddition [email=" + email + ", name=" + name + ", groupId="
				+ groupId + ", buyType=" + buyType + ", custText=" + custText
				+ ", isCustomized=" + isCustomized + "]";
	}
	
	
}
