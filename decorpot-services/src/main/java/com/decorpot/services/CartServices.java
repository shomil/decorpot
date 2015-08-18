package com.decorpot.services;

import org.springframework.web.bind.annotation.RequestBody;

import com.decorpot.cart.models.CartAddition;

public interface CartServices {
	public String addToCart( CartAddition cartAddition);

}
