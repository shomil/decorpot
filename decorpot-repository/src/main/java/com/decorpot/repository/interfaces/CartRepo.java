package com.decorpot.repository.interfaces;

import java.util.List;

import com.decorpot.cart.models.CartAddition;

public interface CartRepo {
	
	public void addToCart( CartAddition cartAdditions);
	public String getCartDetails(String email);

}
