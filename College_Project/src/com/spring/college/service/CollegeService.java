package com.spring.college.service;

import java.util.List;

import com.spring.college.entity.College;

public interface CollegeService {

	public List<College> getColleges();

	public void saveCollege(College college);

	public College getCollege(int id);

	public void deleteCollege(int id);
	
	public College getCollegeIdBasedOnUserId(Integer userId);
}
