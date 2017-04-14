package com.ip.service.impl;

import com.ip.dao.UserDao;
import com.ip.model.User;
import com.ip.service.UserService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public Map<String, Object> register(String phone,String email, String password, String passwordagain,String username) {
		Map<String, Object> map = new HashMap<>();
        phone = phone.trim();
        password = password.trim();
        passwordagain = passwordagain.trim();
        if (password.length() == 0 || passwordagain.length() == 0) {
            map.put("success", false);
            map.put("error", "请输入密码！");
        } else if (!password.equals(passwordagain)) {
            map.put("success", false);
            map.put("error", "两次输入的密码不对应！");
        } else {
            User user = userDao.createUser(username, password,phone,email);
            map.put("success", true);
            map.put("user_id", user.getId());
            map.put("user_name", user.getName());
        }
        return map;
	}
	
	@Override
	public Map<String, Object> login(String username, String password) {
		Map<String, Object> map = new HashMap<>();
        username = username.trim();
        password = password.trim();
        if (username.length() == 0 || password.length() == 0) {
            map.put("success", false);
            map.put("error", "请输入用户名和密码！");
        } else  {
            User user = userDao.findByName(username);
            if (user == null) {
                map.put("success", false);
                map.put("error", "用户名或密码错误！");
            } else {
                if (!password.equals(user.getPassword())) {
                    map.put("success", false);
                    map.put("error", "用户名或密码错误！");
                } else {
                    map.put("success", true);
                    map.put("user_id", user.getId());
                    map.put("user_name", user.getName());
                    map.put("role", (int)user.getRole());
                }
            }
        }
        return map;
	}

	@Override
	public Map<String, Object> deleteUser(String username) {
		Map<String, Object> map = new HashMap<>();
        userDao.delete(username);
        map.put("success", true);
        return map;
	}
	
}
