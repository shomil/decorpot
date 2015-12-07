package com.decorpot.repostory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.decorpot.repository.interfaces.FurnituresRepo;
import com.decorpot.rest.models.Furniture;
import com.decorpot.rest.models.Furnitures;
import com.decorpot.utils.DecorpotConstants;

@Repository
public class FurnituresRepoImpl implements FurnituresRepo {
	
	private JdbcTemplate jdbcTemplate;
	private static final String getAllFurnitures = "select * from Decorpot.furnitures";
	private static final String getAllFurnituresByType = "select * from Decorpot.furnitures where type = ?";
	
	@Autowired
	public FurnituresRepoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Furniture> getAllFurnitures() {
		return jdbcTemplate.query(getAllFurnitures, new FurnitureMapper());
	}

	@Override
	public List<Furniture> getAllFurnituresByType(String type) {
		return jdbcTemplate.query(getAllFurnituresByType, new Object[]{type}, new FurnitureMapper());
	}

	@Override
	public Furniture getFurnitureById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public class FurnitureMapper implements RowMapper<Furniture>{

		@Override
		public Furniture mapRow(ResultSet rs, int rowNum) throws SQLException {
			Furniture furniture = new Furniture();
			furniture.setDescription(rs.getString("DESCRIPTION"));
			furniture.setType(rs.getString("TYPE"));
			furniture.setPrice(rs.getInt("PRICE"));
			furniture.setImageHdPath(DecorpotConstants.HD_COMPRESSED_PATH + rs.getString("imageId") + DecorpotConstants.JPG);
			furniture.setImageId(rs.getString("imageId"));
			furniture.setImageMediumPath(DecorpotConstants.MEDIUM_PATH + rs.getString("imageId") + DecorpotConstants.JPG);
			furniture.setImageSmallPath(DecorpotConstants.SMALL_PATH + rs.getString("imageId") + DecorpotConstants.JPG);
			return furniture;
		}
		
	}

}
