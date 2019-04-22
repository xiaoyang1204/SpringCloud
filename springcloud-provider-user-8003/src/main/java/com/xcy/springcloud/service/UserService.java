package com.xcy.springcloud.service;

import java.util.List;

import com.xcy.springcloud.model.User;

public interface UserService {
	
	int insert(User user);
	
	List<User> findAllUser();
}
