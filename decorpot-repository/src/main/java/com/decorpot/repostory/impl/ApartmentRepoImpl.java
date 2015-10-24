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
	//private final String getAllApartment = "SELECT aa.aprt_group, aa.apartment_name, aa.bhk, aa.image_id, sum(iga.IMAGE_PRICE) price from Decorpot.apartment_attribute aa inner join Decorpot.IMAGE_GROUP_ATTRIBUTE iga on aa.group_id = iga.group_id inner join Decorpot.SPACES_RANK sr on iga.IMAGE_SPACE = sr.IMAGE_SPACE group by aa.aprt_group order by aa.apartment_name, sr.RANK iga.CREATED_DATE";
	private final String getApartment = "SELECT * from Decorpot.apartment_attribute aa inner join Decorpot.IMAGE_GROUP_ATTRIBUTE iga on aa.group_id = iga.group_id inner join Decorpot.SPACES_RANK sr on iga.IMAGE_SPACE = sr.SPACE where aa.aprt_group = ? order by sr.RANK ";
	private final String getAllApartment = "SELECT aa.aprt_group, aa.apartment_name, aa.bhk, aa.image_id, sum(iga1.IMAGE_PRICE) price from Decorpot.apartment_attribute aa inner join (select * from Decorpot.IMAGE_GROUP_ATTRIBUTE iga inner join Decorpot.SPACES_RANK sr on iga.IMAGE_SPACE = sr.SPACE where iga.group_id >= 0 order by sr.RANK) iga1 on aa.group_id = iga1.group_id group by aa.aprt_group order by aa.apartment_name, iga1.CREATED_DATE";
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
		return jdbcTemplate.queryForList(getApartment, aprtId);
	}

}
