package com.decorpot.repository.models;

public class ImageDetail {

	private int group_id;
	private String path_small;
	private String image_description;
	private String image_long_description;
	private int price;
	private String image_title;
	private String basePrice_description;
	private String image_code;
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
	public String getImageTitle() {
		System.out.println("decorpot-core/ImageDetail:getpathSmall()");
		return image_title;
	}
	public void setImageTitle(String image_title) {
		System.out.println("decorpot-core/ImageDetail:setpathSmall()");
		this.image_title = image_title;
	}
	public String getBasePriceDescription() {
		System.out.println("decorpot-core/ImageDetail:getBasePriceDescription()");
		return basePrice_description;
	}
	public void setBasePriceDescription(String basePrice_description) {
		System.out.println("decorpot-core/ImageDetail:setBasePriceDescription()");
		this.basePrice_description = basePrice_description;
	}
	public String getImageCode() {
		System.out.println("decorpot-core/ImageDetail:getImageCode()");
		return image_code;
	}
	public void setImageCode(String image_code) {
		System.out.println("decorpot-core/ImageDetail:setImageCode()");
		this.image_code = image_code;
	}
	@Override
	public String toString() {
		return "ImageList ["
				+ "group_id=" + group_id 
				+ ", path_small=" + path_small
				+ ", image_description=" + image_description 
				+ ", image_long_description=" + image_long_description
				+ ", image_title=" + image_title
				+ ", price=" + price
				+ ", basePrice_description=" + basePrice_description
				+ ", image_code=" + image_code
				+ "]";
	}
	
	
}
