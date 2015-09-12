package com.decorpot.repository.core;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	
	private DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	String USER_CHECK = "select count(*) from(select * from Decorpot.USERS where id=";
	String ADD_USER = "INSERT INTO Decorpot.USERS (id, name, email) VALUES (:id, :name, :email)";
	@Autowired
	public UserRepository(DataSource dataSource){
		System.out.println("decorpot-repository/UserRepository:UserRepository()");
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public boolean addUser(Map<String, Object> user){
		if(jdbcTemplate.queryForObject(USER_CHECK + user.get("id") +") usercount", Integer.class) == 0){
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("id", user.get("id"));
			parameters.put("name", user.get("name"));
			parameters.put("email", user.get("email"));
			
			Object[] params = { user.get("id"), user.get("name"), user.get("email")};

			
			int result = namedParameterJdbcTemplate.update(ADD_USER, parameters);
			System.out.println("result " + result);
			return result > 0;
		}
		return false;
	}
}
