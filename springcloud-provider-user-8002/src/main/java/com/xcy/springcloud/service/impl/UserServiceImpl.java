package com.xcy.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcy.springcloud.dao.UserDao;
import com.xcy.springcloud.model.User;
import com.xcy.springcloud.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public int insert(User user) {
		return userDao.insert(user);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

}
