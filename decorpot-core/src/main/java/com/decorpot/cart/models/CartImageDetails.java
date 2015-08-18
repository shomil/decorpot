package com.decorpot.cart.models;

public class CartImageDetails {
	
	private int groupId;
	private boolean customization;
	private boolean custText;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public boolean isCustomization() {
		return customization;
	}
	public void setCustomization(boolean customization) {
		this.customization = customization;
	}
	public boolean isCustText() {
		return custText;
	}
	public void setCustText(boolean custText) {
		this.custText = custText;
	}
	@Override
	public String toString() {
		return "CartImageDetails [groupId=" + groupId + ", customization="
				+ customization + ", custText=" + custText + "]";
	}
	
	
}
