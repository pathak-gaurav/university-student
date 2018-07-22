package com.spring.college.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.college.entity.College;
import com.spring.college.rm.CollegeRowMapper;

@Repository
public class CollegeDaoImpl extends BaseDAO implements CollegeDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	public List<College> getColleges() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<College> query = currentSession.createQuery("from College", College.class);
		List<College> resultList = query.getResultList();
		logger.info("listing all the colleges:" + resultList);
		return resultList;
	}

	@Override
	public void saveCollege(College college) {
		Session currentSession = sessionFactory.getCurrentSession();
		logger.info("saving the college" + college);
		currentSession.saveOrUpdate(college);
	}

	@Override
	public College getCollege(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		College collegeBean = currentSession.get(College.class, id);
		logger.info("Retrieving the college:" + collegeBean);
		return collegeBean;
	}

	@Override
	public void deleteCollege(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		College collegeBean = currentSession.get(College.class, id);
		logger.info("deleting the college" + collegeBean);
		currentSession.delete(collegeBean);
	}

	@Override
	public void update(College c) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(c);
	}

	@Override
	public List<College> findByProperty(String propName, Object propValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public College getCollegeIdBasedOnUserId(Integer userId) {
		String sql = "SELECT c.id,c.name,c.address,c.state,c.city,c.phone "
				+ " FROM college c INNER JOIN user u ON (c.name=u.firstName) WHERE u.roleId=5 and userId=? ";
		return getJdbcTemplate().queryForObject(sql, new CollegeRowMapper(), userId);
	}
}
