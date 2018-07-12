package com.spring.college.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.college.entity.Marksheet;

public class MarksheetRowMapper implements RowMapper<Marksheet> {

	@Override
	public Marksheet mapRow(ResultSet rs, int rowNum) throws SQLException {
		Marksheet m = new Marksheet();
		m.setRollno(rs.getString("rollno"));
		m.setChemistry(rs.getString("chemistry"));
		m.setPhysics(rs.getString("physics"));
		m.setMaths(rs.getString("maths"));
		m.setId(rs.getInt("id"));
		m.setStudentId(rs.getInt("studentId"));
		m.setName(rs.getString("name"));
		return m;
	}
}
