package com.spring.college.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.college.entity.Student;
import com.spring.college.entity.User;

@Repository
public class UserDaoImpl  extends BaseDAO  implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	Logger logger = Logger.getLogger(this.getClass().getName());

	/*
	@Override
	public void register(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		logger.info("savining in user table:" + user);
		currentSession.saveOrUpdate(user);
	}

	@Autowired
	@PersistenceContext
	EntityManager em;
	
	@Override
	public boolean validateUser(String username,String password) {
		boolean userFound=false;
		Session currentSession = sessionFactory.getCurrentSession();
		 List<User> list = currentSession.createQuery("SELECT u FROM User u WHERE u.login LIKE:lo AND u.password LIKE:pa ",User.class).
		setParameter("lo",username).setParameter("pa",password).getResultList();
		 if((list !=null) && (list.size()>0)) {
			 userFound=true;
			 logger.info("User found for login");
		 }
		return userFound;
	}
	 	*/
	@Override
	public List<User> getUsers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> createQuery = currentSession.createQuery("from User", User.class);
		List<User> resultList = createQuery.getResultList();
		logger.info("Listing all the User from DB{}" + resultList);
		return resultList;
	}

	@Override
	public User getUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User userBean = currentSession.get(User.class, id);
		return userBean;
	}

	@Override
	public void addUser(User userBean) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(userBean);
	}

	@Override
	public void deleteUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User userBean = currentSession.get(User.class, id);
		currentSession.delete(userBean);
	}

	@Override
	public List<User> findByListId(Integer userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> createQuery = currentSession.createQuery("from User where userId="+userId, User.class);
		return createQuery.getResultList();
	}
}
