package com.spring.college.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.college.entity.College;

public class CollegeRowMapper implements RowMapper<College> {

	@Override
	public College mapRow(ResultSet rs, int rowNum) throws SQLException {
		College c = new College();
		c.setName(rs.getString("name"));
		c.setAddress(rs.getString("address"));
		c.setCity(rs.getString("city"));
		c.setPhone(rs.getString("phone"));
		c.setState(rs.getString("state"));
		c.setId(rs.getInt("id"));
		return c;
	}

}
