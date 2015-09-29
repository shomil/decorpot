package com.decorpot.repostory.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.decorpot.repository.interfaces.ApartmentRepo;

@Repository
public class ApartmentRepoImpl implements ApartmentRepo {

	private JdbcTemplate jdbcTemplate;
	private final String getAllApartment = "SELECT aa.aprt_group, aa.apartment_name, aa.bhk, aa.image_id, sum(iga.IMAGE_PRICE) price from Decorpot.apartment_attribute aa inner join Decorpot.IMAGE_GROUP_ATTRIBUTE iga on aa.group_id = iga.group_id group by aa.aprt_group";
	private final String getApartment = "SELECT iga.group_id, iga.IMAGE_PRICE, iga.IMAGE_DESCRIPTION, iga.image_space from Decorpot.apartment_attribute aa inner join Decorpot.IMAGE_GROUP_ATTRIBUTE iga on aa.group_id = iga.group_id where aprt_group = ?";
	
	@Autowired
	public ApartmentRepoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Map<String, Object>> getAllApartment() {
		return jdbcTemplate.queryForList(getAllApartment);
	}

	@Override
	public List<Map<String, Object>> getApartment(int aprtId) {
		return jdbcTemplate.queryForList(getAllApartment, aprtId);
	}

}
