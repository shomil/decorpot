package com.decorpot.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author vaseem.mohammed
 *
 */
@Repository
public class DecorpotRepository {
	

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DecorpotRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<DatabaseList> getImages(){
		return jdbcTemplate.query("show databases", new RowMapper<DatabaseList>() {

			@Override
			public DatabaseList mapRow(ResultSet rs, int rowNum) throws SQLException {
				DatabaseList databaseList = new DatabaseList();
				databaseList.setDatabaseName(rs.getString(1));
				return databaseList;
			}
		});
	}
}
