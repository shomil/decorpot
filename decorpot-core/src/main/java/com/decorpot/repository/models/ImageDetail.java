package com.decorpot.repository.models;

public class ImageDetail {

	private int groupId;
	private String pathSmall;
	private String descriptionShort;
	private int price;
	public int getGroupId() {
		System.out.println("decorpot-core/ImageDetail:getGroupId()");
		return groupId;
	}
	public void setGroupId(int groupId) {
		System.out.println("decorpot-core/ImageDetail:setGroupId()");
		this.groupId = groupId;
	}
	public String getPathSmall() {
		System.out.println("decorpot-core/ImageDetail:getpathSmall()");
		return pathSmall;
	}
	public void setPathSmall(String pathSmall) {
		System.out.println("decorpot-core/ImageDetail:setpathSmall()");
		this.pathSmall = pathSmall;
	}
	public String getDescriptionShort() {
		System.out.println("decorpot-core/ImageDetail:getDescriptionShort()");
		return descriptionShort;
	}
	public void setDescriptionShort(String descriptionShort) {
		System.out.println("decorpot-core/ImageDetail:setDescriptionShort()");
		this.descriptionShort = descriptionShort;
	}
	public int getPrice() {
		System.out.println("decorpot-core/ImageDetail:getPrice()");
		return price;
	}
	public void setPrice(int price) {
		System.out.println("decorpot-core/ImageDetail:setPrice()");
		this.price = price;
	}
	@Override
	public String toString() {
		return "ImageList [groupId=" + groupId + ", pathSmall=" + pathSmall
				+ ", descriptionShort=" + descriptionShort + ", price=" + price
				+ "]";
	}
	
	
}
