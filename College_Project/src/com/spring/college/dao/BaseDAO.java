package com.spring.college.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

abstract public class BaseDAO extends NamedParameterJdbcDaoSupport {

	@Autowired
	public void setDataSource2(DataSource da) {
		super.setDataSource(da);
	}
}