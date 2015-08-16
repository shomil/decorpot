package com.decorpot.cart.models;

import java.util.Arrays;

public class CartAddition {
	
	private String email;
	private String name;
	private int [] groupId;
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
	public int[] getGroupId() {
		return groupId;
	}
	public void setGroupId(int[] groupId) {
		this.groupId = groupId;
	}
	@Override
	public String toString() {
		return "CartAddition [email=" + email + ", name=" + name + ", groupId="
				+ Arrays.toString(groupId) + "]";
	}

}
