package com.spring.college.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.college.entity.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student s = new Student();
		s.setCollegeId(rs.getInt("collegeId"));
		s.setStudentId(rs.getInt("studentId"));
		s.setCollegeName(rs.getString("collegeName"));
		s.setFirstName(rs.getString("firstName"));
		s.setLastName(rs.getString("lastName"));
		s.setEmail(rs.getString("email"));
		s.setMobile(rs.getString("mobile"));
		return s;
	}

}
