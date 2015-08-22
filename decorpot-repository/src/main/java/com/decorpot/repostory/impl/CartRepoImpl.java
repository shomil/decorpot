package com.decorpot.repostory.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.decorpot.cart.models.CartAddition;
import com.decorpot.repository.interfaces.CartRepo;

@Repository
public class CartRepoImpl implements CartRepo {

	private JdbcTemplate jdbcTemplate;
	private String addToCartSql = "insert into Decorpot.cart (EMAIL, NAME, GROUP_ID, BUY_TYPE, CUST_TEXT, IS_CUSTOMIZED) values (?, ?, ?, ?, ?, ?)";

	@Autowired
	public CartRepoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addToCart(CartAddition cartAddition) {
		
			jdbcTemplate.update(
					addToCartSql,
					new Object[] { cartAddition.getEmail(),
							cartAddition.getName(), cartAddition.getGroupId(),
							cartAddition.getBuyType(),
							cartAddition.getCustText(), cartAddition.isCustomized() });

	}

	@Override
	public String getCartDetails(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
