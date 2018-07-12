package com.spring.college.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.college.entity.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u = new User();
		u.setConfirmPassword(rs.getString("confirmPassword"));
		u.setDob(rs.getDate("dob"));
		u.setFirstName(rs.getString("firstName"));
		u.setGender(rs.getString("gender"));
		u.setLastName(rs.getString("lastName"));
		u.setLock(rs.getInt("lock"));
		u.setLogin(rs.getString("login"));
		u.setMobile(rs.getString("mobile"));
		u.setPassword(rs.getString("password"));
		u.setRoleId(rs.getInt("roleId"));
		u.setUserId(rs.getInt("userId"));
		return u;
	}
}
