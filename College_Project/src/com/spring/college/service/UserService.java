package com.spring.college.service;

import java.util.List;

import com.spring.college.entity.User;

public interface UserService {
	

	public static final Integer LOCK_STATUS_ACTIVE = 1;
	public static final Integer LOCK_STATUS_BLOCKED = 2;

	public static final Integer ROLE_ADMIN = 1;
	public static final Integer ROLE_USER = 2;
	public static final Integer ROLE_STUDENT = 3;
	public static final Integer ROLE_KIOSK = 4;
	public static final Integer ROLE_COLLEGE = 5;
	
	public User login(String loginName, String password);

	public List<User> getUsers();

	public User getUser(int id);

	public void addUser(User userBean);

	public void deleteUser(int id);
	
	public List<User> findByListId(Integer userId);
}