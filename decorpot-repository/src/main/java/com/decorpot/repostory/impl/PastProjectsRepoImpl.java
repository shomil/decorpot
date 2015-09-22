package com.decorpot.repostory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.decorpot.repository.interfaces.PastProjectsRepo;

@Repository
public class PastProjectsRepoImpl implements PastProjectsRepo {

	private JdbcTemplate jdbcTemplate;
	private final String projectsList = "SELECT    SMALL_PATH,MEDIUM_PATH,APARTMENT FROM Decorpot.WORKDONEIMAGE_ATTRIBUTE group  BY  APARTMENT";
	private final String projectImageList = "SELECT HD_PATH, SMALL_PATH FROM Decorpot.WORKDONEIMAGE_ATTRIBUTE where APARTMENT=?";

	@Autowired
	public PastProjectsRepoImpl(DataSource dataSource) {
		System.out
				.println("Decorpot-respository/PastProjectsRepoImpl:constructor");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Map<String, Object>> getAllProjects() {
		List<Map<String, Object>> data = jdbcTemplate.queryForList(projectsList);
		return data;
	}

	@Override
	public List<Map<String, Object>> getImagesByAppartment(String project) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForList(projectImageList, project);
	}
}