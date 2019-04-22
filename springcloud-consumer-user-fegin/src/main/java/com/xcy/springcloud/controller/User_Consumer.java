package com.xcy.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xcy.springcloud.model.User;
import com.xcy.springcloud.service.UserClientService;

@RestController
@RequestMapping("/consumer")
public class User_Consumer {
	
//	private static final String REST_URL_PREFIX = "http://localhost:8001";
	
//	private static final String REST_URL_PREFIX = "http://MICROS-DEPT"; //微服务真实名字
	
	@Autowired
	private UserClientService userClientService;
	
	@RequestMapping(value = "/insert")
	public Integer insert(User user) {
		return userClientService.insert(user);
	}

	@RequestMapping(value = "/findAllUser")
	public List<User> findAllUser(){
		return userClientService.findAllUser();
	}
	
}
