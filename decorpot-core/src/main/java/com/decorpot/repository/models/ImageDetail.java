package com.decorpot.repository.models;

public class ImageDetail {

	private int groupId;
	private String pathSmall;
	private String descriptionShort;
	private int price;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getPathSmall() {
		return pathSmall;
	}
	public void setPathSmall(String pathSmall) {
		this.pathSmall = pathSmall;
	}
	public String getDescriptionShort() {
		return descriptionShort;
	}
	public void setDescriptionShort(String descriptionShort) {
		this.descriptionShort = descriptionShort;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ImageList [groupId=" + groupId + ", pathSmall=" + pathSmall
				+ ", descriptionShort=" + descriptionShort + ", price=" + price
				+ "]";
	}
	
	
}
