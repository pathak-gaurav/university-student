package com.spring.college.dao;

import java.util.List;

import com.spring.college.entity.Student;

public interface StudentDao {

	public List<Student> getStudents();

	public void saveStudent(Student studentBean);

	public Student getStudent(int id);
	
	public void deleteStudent(int id);
	
	public Student getDetails(int id);
	
	public List<Student> findByCollegeId(Integer collegeId);
	
}
