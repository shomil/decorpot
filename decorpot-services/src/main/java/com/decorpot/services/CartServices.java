package com.decorpot.services;

import com.decorpot.cart.models.CartAddition;
import com.decorpot.cart.models.CartDetails;

public interface CartServices {
	public void addToCart( CartAddition cartAddition);
	public CartDetails getCartDetails(String email);
}
