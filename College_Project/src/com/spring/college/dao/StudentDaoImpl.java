package com.spring.college.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.college.entity.Student;

@Repository
public class StudentDaoImpl extends BaseDAO implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	public List<Student> getStudents() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Student> createQuery = currentSession.createQuery("from Student", Student.class);
		List<Student> resultList = createQuery.getResultList();
		logger.info("Listing all the Student from DB{}" + resultList);
		return resultList;
	}

	@Override
	public void saveStudent(Student studentBean) {
		Session currentSession = sessionFactory.getCurrentSession();
		logger.info("Saving Student-->" + studentBean);
		currentSession.saveOrUpdate(studentBean);
	}

	@Override
	public Student getStudent(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Student studentBean = currentSession.get(Student.class, id);
		logger.info("Retreving the Student:{}" + studentBean);
		return studentBean;
	}

	@Override
	public void deleteStudent(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Student studentBean = currentSession.get(Student.class, id);
		logger.info("Deleting the student:" + studentBean);
		currentSession.delete(studentBean);
	}

}
