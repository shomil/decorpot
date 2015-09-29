package com.decorpot.repository.models;

import java.util.List;

public class Apartment {

	private double totalPrice;
	private String apartmentName;
	private int aprtId;
	private String bhk;
	private List<ImageGroup> groups;
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	public int getAprtId() {
		return aprtId;
	}
	public void setAprtId(int aprtId) {
		this.aprtId = aprtId;
	}
	public List<ImageGroup> getGroups() {
		return groups;
	}
	public void setGroups(List<ImageGroup> groups) {
		this.groups = groups;
	}
	public String getBhk() {
		return bhk;
	}
	public void setBhk(String bhk) {
		this.bhk = bhk;
	}
	
}
