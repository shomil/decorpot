package com.decorpot.repostory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.decorpot.cart.models.CartAddition;
import com.decorpot.cart.models.CartDetails;
import com.decorpot.cart.models.CartImageDetails;
import com.decorpot.repository.interfaces.CartRepo;
import com.decorpot.repository.models.ImageDetail;

@Repository
public class CartRepoImpl implements CartRepo {

	private JdbcTemplate jdbcTemplate;
	private String addToCartSql = "insert into Decorpot.cart (EMAIL, NAME, GROUP_ID, BUY_TYPE, CUST_TEXT, IS_CUSTOMIZED) values (?, ?, ?, ?, ?, ?)";

	private String cartDetailsSql = "select * from Decorpot.cart where email = ?";
	@Autowired
	public CartRepoImpl(DataSource dataSource) {
		System.out.println("decorpot-repository/CartRepoImpl:CartRepoImpl()");
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
	public CartDetails getCartDetails(String email) {
		CartDetails cartDetails = new CartDetails();
		List<CartImageDetails> details =  jdbcTemplate.query(cartDetailsSql, new Object[]{ email }, new CartImageDetailsMapper());
		cartDetails.setImageDetails(details);
		return cartDetails;
	}

	public class CartImageDetailsMapper implements RowMapper<CartImageDetails> {
		public CartImageDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			CartImageDetails imgDetail = new CartImageDetails();
			return imgDetail;
		   }
		}
}
