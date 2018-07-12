package com.spring.college.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.college.entity.Marksheet;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marksheet getMarksheetIdBasedOnUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
