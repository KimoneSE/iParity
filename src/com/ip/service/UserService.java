package com.ip.service;

import java.util.Map;

public interface UserService {

	Map<String, Object> register(String phone, String email, String password, String passwordagain, String username);

	public Map<String, Object> login(String username, String password);
	
	public Map<String, Object> deleteUser(String username);
}
