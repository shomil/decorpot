package com.decorpot.repository.interfaces;

import com.decorpot.cart.models.CartAddition;
import com.decorpot.cart.models.CartDetails;

public interface CartRepo {
	
	public void addToCart( CartAddition cartAdditions);
	public CartDetails getCartDetails(String email);

}
