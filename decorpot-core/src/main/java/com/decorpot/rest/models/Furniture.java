package com.decorpot.rest.models;

public class Furniture {
	
	private int id;
	private String type;
	private String imageId;
	private String description;
	private int price;
	private String imageHdPath;
	private String imageMediumPath;
	private String imageSmallPath;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getImageHdPath() {
		return imageHdPath;
	}
	public void setImageHdPath(String imageHdPath) {
		this.imageHdPath = imageHdPath;
	}
	public String getImageMediumPath() {
		return imageMediumPath;
	}
	public void setImageMediumPath(String imageMediumPath) {
		this.imageMediumPath = imageMediumPath;
	}
	public String getImageSmallPath() {
		return imageSmallPath;
	}
	public void setImageSmallPath(String imageSmallPath) {
		this.imageSmallPath = imageSmallPath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
