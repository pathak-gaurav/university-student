package com.spring.college.dao;

import java.util.List;

import com.spring.college.entity.Marksheet;

public interface MarksheetDao {

	public List<Marksheet> getMarksheets();

	public void saveMarksheet(Marksheet marksheet);

	public Marksheet getMarksheet(int id);

	public void deleteMarksheet(int id);

	public void update(Marksheet c);

	public List<Marksheet> findByProperty(String propName, Object propValue);

	public List<Marksheet> getMarksheetIdBasedOnUserId(Integer userId);
}
