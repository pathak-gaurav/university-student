package com.spring.college.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.college.dao.BaseDAO;
import com.spring.college.dao.UserDao;
import com.spring.college.entity.User;
import com.spring.college.rm.UserRowMapper;

@Repository
public class UserServiceImpl  extends BaseDAO  implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User login(String login, String password) {
		String sql = "SELECT `userId`,`roleId`,`lastName`,`firstName`,`login`,`password`,`confirmPassword`,`mobile`,`gender`,`dob`,`lock`"
				+ " FROM `user` WHERE (login=:ln) AND (password=:pw)";
		Map m = new HashMap();
		m.put("ln", login);
		m.put("pw", password);
		try {
			User user = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
			logger.info(user.toString());
			if (user.getLock().equals(LOCK_STATUS_ACTIVE)) {
				return user;
			}
			return user;
		} catch (EmptyResultDataAccessException ex) {
			ex.printStackTrace();
			throw new RuntimeException("Invalid Credentials!!.");
		}
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	@Transactional
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Override
	@Transactional
	public void addUser(User userBean) {
		userDao.addUser(userBean);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
	
	@Override
	@Transactional
	public List<User> findByListId(Integer userId){
		return userDao.findByListId(userId);
	}

}
