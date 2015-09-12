package com.decorpot.repository.models;

public class Image {
	
	private String imagePathHd;
	private int imageId;
	private int viewId;
	private String imagePathSmall;
	public String getImagePathHd() {
		System.out.println("decorpot-core/Image:getImagePathHd");
		return imagePathHd;
	}
	public void setImagePathHd(String imagePathHd) {
		System.out.println("decorpot-core/Image:setImagePathHd");
		this.imagePathHd = imagePathHd;
	}
	public int getImageId() {
		System.out.println("decorpot-core/Image:getImageId");
		return imageId;
	}
	public void setImageId(int imageId) {
		System.out.println("decorpot-core/Image:setImageId");
		this.imageId = imageId;
	}
	public int getViewId() {
		System.out.println("decorpot-core/Image:getViewId");
		return viewId;
	}
	public void setViewId(int viewId) {
		this.viewId = viewId;
	}
	public String getImagePathSmall() {
		System.out.println("decorpot-core/Image:getImagePathSmall");
		return imagePathSmall;
	}
	public void setImagePathSmall(String imagePathSmall) {
		System.out.println("decorpot-core/Image:setImagePathSmall");
		this.imagePathSmall = imagePathSmall;
	}
	
	
}
