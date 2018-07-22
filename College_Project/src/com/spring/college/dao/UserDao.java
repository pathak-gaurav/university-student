package com.spring.college.dao;

import java.util.List;

import com.spring.college.entity.User;

public interface UserDao {
	
	public List<User> getUsers();
	
	public User getUser(int id) ;
	
	public void addUser(User userBean);
	
	public void deleteUser(int id);
	
	public List<User> findByListId(Integer userId);
	
}