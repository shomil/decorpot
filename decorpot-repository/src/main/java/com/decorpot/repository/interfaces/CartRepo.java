package com.decorpot.repository.interfaces;

import com.decorpot.cart.models.CartAddition;

public interface CartRepo {
	
	public String addToCart( CartAddition cartAddition);
	public String getCartDetails(String email);

}
