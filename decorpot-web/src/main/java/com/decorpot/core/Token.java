package com.decorpot.core;

public class Token {
	String token;

	public Token(String token) {
		System.out.println("Token Constructor");
		this.token = token;
	}

	public String getToken() {
		System.out.println("Token:getToken()");
		return token;
	}
}
