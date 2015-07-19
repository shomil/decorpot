package com.decorpot.repostory.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.decorpot.repository.interfaces.ImageList;

@Repository
public class ImageListImpl implements ImageList {

	private Integer defaultToPrice = 300000;
	private Integer defaultFromPrice = 100000;
	private JdbcTemplate jdbcTemplate;

	private String imageListSql = "SELECT * FROM Decorpot.image_categorization ic inner join Decorpot.group_color_mapping gcm on  ic.groupid= gcm.groupid inner join Decorpot.image_location il on gcm.imageid = il.imageid inner join (select groupid, min(price) price from Decorpot.group_price_mapping where price >= ? and price <= ? group by groupid) priceTemp on priceTemp.groupid = ic.groupid where ic.spaces = ? LIMIT ?,?";

	@Autowired
	public ImageListImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Map<String, Object>> getImageListSpace(String space, Integer toPrice, Integer fromPrice, Integer to, Integer from) {
		if(toPrice == null)
			toPrice = this.defaultToPrice;
		if(fromPrice == null)
			fromPrice = this.defaultFromPrice;
		System.out.println(to +"  "+ from+"  " + fromPrice+"   "+toPrice+"  "+space);
		return jdbcTemplate.queryForList(imageListSql,200000,300000,space,from,to);
	}

}
