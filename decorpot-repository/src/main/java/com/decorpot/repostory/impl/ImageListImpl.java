package com.decorpot.repostory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.decorpot.repository.interfaces.ImageList;
import com.decorpot.repository.models.ImageDetail;

@Repository
public class ImageListImpl implements ImageList {

	private Integer defaultToPrice = 300000;
	private Integer defaultFromPrice = 100000;
	private JdbcTemplate jdbcTemplate;

	private String imageListSql = "SELECT * FROM Decorpot.image_categorization ic inner join Decorpot.group_color_mapping gcm on  ic.groupid= gcm.groupid inner join Decorpot.image_location il on gcm.imageid = il.imageid inner join (select groupid, min(price) price from Decorpot.group_price_mapping where price >= ? and price <= ? group by groupid) priceTemp on priceTemp.groupid = ic.groupid where ic.spaces = ? LIMIT ?,?";

	private String imageViewByColorSql = "select * from Decorpot.image_location il inner join Decorpot.group_color_mapping gcm on gcm.imageid = il.imageid where gcm.groupid = ? and gcm.color = ?";
	
	private String colorByGroupid = "select color from Decorpot.group_color_mapping where groupid = ?";
	
	
	@Autowired
	public ImageListImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<ImageDetail> getImageListSpace(String space, Integer toPrice, Integer fromPrice, Integer to, Integer from) {
		if(toPrice == null)
			toPrice = this.defaultToPrice;
		if(fromPrice == null)
			fromPrice = this.defaultFromPrice;
		Map<String, Object> params = new HashMap<>();
		params.put("toPrice", toPrice);
		params.put("fromPrice", fromPrice);
		params.put("space", space);
		params.put("to", to);
		params.put("from", from);
		
		System.out.println("getImageListSpace" +to +"  "+ from+"  " + fromPrice+"   "+toPrice+"  "+space);
		List<ImageDetail> imgDetailsList =  jdbcTemplate.query(imageListSql, new Object[] {fromPrice, toPrice, space, from, to}, new ImageDetailMapper());
		return imgDetailsList;
	}
	public class ImageDetailMapper implements RowMapper<ImageDetail> {
	public ImageDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		ImageDetail imgDetail = new ImageDetail();
		imgDetail.setGroupId(rs.getInt("groupid"));
		imgDetail.setPathSmall(rs.getString("path_small"));
		imgDetail.setPrice(rs.getInt("price"));
		imgDetail.setDescriptionShort(rs.getString("description_short"));
	      return imgDetail;
	   }
	}

	@Override
	public List<Map<String, Object>> getViewsByColors(String color, int groupid) {
		// TODO Auto-generated method stub
		 return jdbcTemplate.queryForList(imageViewByColorSql,groupid,color);
	}

	@Override
	public List<Map<String, Object>> getColorsByGroup(int groupid) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForList(colorByGroupid,groupid);
	}

	@Override
	public List<Map<String, Object>> getImageListTheme(String theme, Integer toPrice, Integer fromPrice, Integer to, Integer from) {
		if(toPrice == null) toPrice = this.defaultToPrice;
		if(fromPrice ==null) fromPrice = this.defaultFromPrice;
		theme = "living";
		System.out.println("getImageListTheme" +to +"  "+ from+"  " + fromPrice+"   "+toPrice+"  "+theme);
		return jdbcTemplate.queryForList(imageListSql,200000,300000,theme,from,to);
	}

	@Override
	public List<ImageDetail> getImageListSpace(int groupId) {
		// TODO Auto-generated method stub
		return null;
	}


}
