package com.spring.college.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.college.entity.Marksheet;
import com.spring.college.rm.MarksheetRowMapper;

@Repository
public class MarksheetDaoImpl extends BaseDAO implements MarksheetDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	public List<Marksheet> getMarksheets() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Marksheet> query = currentSession.createQuery("from Marksheet", Marksheet.class);
		List<Marksheet> resultList = query.getResultList();
		logger.info("listing all the marksheets:" + resultList);
		return resultList;
	}

	@Override
	public void saveMarksheet(Marksheet marksheet) {
		Session currentSession = sessionFactory.getCurrentSession();
		logger.info("saving the marksheet" + marksheet);
		currentSession.saveOrUpdate(marksheet);
	}

	@Override
	public Marksheet getMarksheet(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Marksheet marksheetBean = currentSession.get(Marksheet.class, id);
		logger.info("Retrieving the marksheet:" + marksheetBean);
		return marksheetBean;
	}

	@Override
	public void deleteMarksheet(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Marksheet marksheetBean = currentSession.get(Marksheet.class, id);
		logger.info("deleting the marksheet" + marksheetBean);
		currentSession.delete(marksheetBean);
	}

	@Override
	public void update(Marksheet c) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(c);
	}

	@Override
	public List<Marksheet> findByProperty(String propName, Object propValue) {
		return null;
	}

	@Override
	public List<Marksheet> getMarksheetIdBasedOnUserId(Integer userId) {
		String sql = "SELECT m.id,m.rollno,m.studentId,m.name,m.physics,m.chemistry,m.maths\r\n" + 
				" from marksheet m INNER JOIN student s on (m.studentId=s.studentId)\r\n" + 
				" INNER JOIN USER U on (u.firstName=s.firstName) and (u.lastName=s.lastName) where u.userId=? ";
		return getJdbcTemplate().query(sql, new MarksheetRowMapper(), userId);
	}
}
