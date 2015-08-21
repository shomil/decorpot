package com.decorpot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decorpot.cart.models.CartAddition;
import com.decorpot.repository.interfaces.CartRepo;

@Service
public class CartServiceImpl implements CartServices {

	@Autowired
	private CartRepo cartRepo;

	@Override
	public void addToCart(CartAddition cartAddition) {
		try {
			cartRepo.addToCart(cartAddition);
		} catch (Exception e) {
			throw e;
		}
	}

}
