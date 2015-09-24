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
	private String imageSpaceSql = "SELECT * FROM Decorpot.GROUP_ATTRIBUTE ga inner join Decorpot.IMAGE_ATTRIBUTE ia on ga.group_id = ia.group_id where ia.image_price >= ? and ia.image_price <= ? and  ga.space = ? and ia.view_id = 1";
	//private String imageViewByColorSql = "select * from Decorpot.image_location il inner join Decorpot.group_color_mapping gcm on gcm.imageid = il.imageid where gcm.groupid = ? and gcm.color = ?";
	private String imageViewByColorSql = "select * from Decorpot.IMAGE_ATTRIBUTE where group_id = ? and color  = ?";
	private String colorByGroupid = "SELECT color from Decorpot.IMAGE_ATTRIBUTE where group_id = ?";
	
	
	@Autowired
	public ImageListImpl(DataSource dataSource) {
		System.out.println("Decorpot-respository/ImageListImpl:constructor");
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
		System.out.println("decorpot-repository/ImageListImpl:getImageListSpace");
		System.out.println("getImageListSpace" +to +"  "+ from+"  " + fromPrice+"   "+toPrice+"  "+space);
		//List<ImageDetail> imgDetailsList =  jdbcTemplate.query(imageListSql, new Object[] {fromPrice, toPrice, space, from, to}, new ImageDetailMapper());
		List<ImageDetail> imgDetailsList =  jdbcTemplate.query(imageSpaceSql, new Object[] {fromPrice, toPrice, space}, new ImageDetailMapper());
		System.out.println("queryDone");
		return imgDetailsList;
	}
	public class ImageDetailMapper implements RowMapper<ImageDetail> {
	public ImageDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("decorpot-repository/ImageListImpl:ImageDetailMapper" );
		System.out.println("rs = "+rs +" rowNum = "+rowNum);
		ImageDetail imgDetail = new ImageDetail();
		/*imgDetail.setGroupId(rs.getInt("groupid"));
		imgDetail.setPathSmall(rs.getString("path_small"));
		imgDetail.setPrice(rs.getInt("price"));
		imgDetail.setDescriptionShort(rs.getString("description_short"));*/
		imgDetail.setGroupId(rs.getInt("group_id"));
		imgDetail.setPathSmall(rs.getString("image_path"));
		imgDetail.setPrice(rs.getInt("image_price"));
		imgDetail.setDescriptionShort(rs.getString("image_description"));
		System.out.println("Image Detail return ");
	    return imgDetail;
	   }
	}

	@Override
	public List<Map<String, Object>> getViewsByColors(String color, int groupid) {
		// TODO Auto-generated method stub
		System.out.println("decorpot-repository/ImageListImpl:getViewsByColors()");
		 return jdbcTemplate.queryForList(imageViewByColorSql,groupid,color);
	}

	@Override
	public List<Map<String, Object>> getColorsByGroup(int groupid) {
		// TODO Auto-generated method stub
		System.out.println("decorpot-repository/ImageListImpl:getColorsByGroup()");
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
