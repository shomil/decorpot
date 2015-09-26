package com.decorpot.repository.models;

public class ImageDetail {

	private int group_id;
	private String path_small;
	private String image_description;
	private String image_long_description;
	private int price;
	public int getGroupId() {
		System.out.println("decorpot-core/ImageDetail:getGroupId()");
		return group_id;
	}
	public void setGroupId(int group_Id) {
		System.out.println("decorpot-core/ImageDetail:setGroupId()");
		this.group_id = group_Id;
	}
	public String getPathSmall() {
		System.out.println("decorpot-core/ImageDetail:getpathSmall()");
		return path_small;
	}
	public void setPathSmall(String path_small) {
		System.out.println("decorpot-core/ImageDetail:setpathSmall()");
		this.path_small = path_small;
	}
	public String getDescriptionShort() {
		System.out.println("decorpot-core/ImageDetail:getDescriptionShort()");
		return image_description;
	}
	public void setDescriptionShort(String image_description) {
		System.out.println("decorpot-core/ImageDetail:setDescriptionShort()");
		this.image_description = image_description;
	}
	public String getImageLongDescription() {
		System.out.println("decorpot-core/ImageDetail:getImageLongDescription()");
		return image_long_description;
	}
	public void setImageLongDescription(String image_long_description) {
		System.out.println("decorpot-core/ImageDetail:setImageLongDescription()");
		this.image_long_description = image_long_description;
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
		return "ImageList [group_id=" + group_id + ", path_small=" + path_small
				+ ", image_description=" + image_description +", image_long_description=" + image_long_description
				+", price=" + price
				+ "]";
	}
	
	
}
