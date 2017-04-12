package com.ip.dao;

import com.ip.model.User;

public interface UserDao {

	public User createUser(String username, String password,String phone,String email);
	
	public User createAdmin(String adminname, String password);
	
	public User findByName(String username);
	
	public void delete(String username);
	
}
