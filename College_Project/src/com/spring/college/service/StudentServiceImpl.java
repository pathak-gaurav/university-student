package com.spring.college.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.college.dao.StudentDao;
import com.spring.college.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentBeanDao;

	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentBeanDao.getStudents();
	}

	@Override
	@Transactional
	public Student getStudent(int id) {
		return studentBeanDao.getStudent(id);
	}

	@Override
	@Transactional
	public void saveStudent(Student studentBean) {
		studentBeanDao.saveStudent(studentBean);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		studentBeanDao.deleteStudent(id);
	}

	@Override
	@Transactional
	public List<Student> findByCollegeId(Integer userId){
		return studentBeanDao.findByCollegeId(userId);
	}
}
