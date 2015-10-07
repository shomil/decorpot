package com.decorpot.repository.models;

public class ImageGroup {
	
	private int groupId;
	private String imageTitle;
	private String imageDescription;
	private String imageTheme;
	private String imageSpace;
	private double basePrice;
	private String basePrice_description;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getImageTitle() {
		return imageTitle;
	}
	public void setImageTitle(String imageTitle) {
		this.imageTitle = imageTitle;
	}
	public String getImageDescription() {
		return imageDescription;
	}
	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}
	public String getImageTheme() {
		return imageTheme;
	}
	public void setImageTheme(String imageTheme) {
		this.imageTheme = imageTheme;
	}
	public String getImageSpace() {
		return imageSpace;
	}
	public void setImageSpace(String imageSpace) {
		this.imageSpace = imageSpace;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public String getBasePriceDescription() {
		return basePrice_description;
	}
	public void setBasePriceDescription(String basePrice_description) {
		this.basePrice_description = basePrice_description;
	}
	

}
