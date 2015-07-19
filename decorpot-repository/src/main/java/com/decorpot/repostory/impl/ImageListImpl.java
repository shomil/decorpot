package com.decorpot.repostory.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.decorpot.repository.interfaces.ImageList;

@Repository
public class ImageListImpl implements ImageList {

private JdbcTemplate jdbcTemplate;
	
private String imageListSql = "SELECT * FROM Decorpot.image_categorization ic inner join Decorpot.group_color_mapping gcm on  ic.groupid= gcm.groupid inner join Decorpot.image_location il on gcm.imageid = il.imageid inner join (select groupid, min(price) price from Decorpot.group_price_mapping where price > 0 group by groupid) priceTemp on priceTemp.groupid = ic.groupid;";

	@Autowired
	public ImageListImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Map<String, Object>> getImageListing(String theme) {
			return jdbcTemplate.queryForList(imageListSql);
	}

}
