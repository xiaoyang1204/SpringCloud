package com.xcy.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xcy.springcloud.model.User;

@RestController
@RequestMapping("/consumer")
public class User_Consumer {
	
//	private static final String REST_URL_PREFIX = "http://localhost:8001";
	
	private static final String REST_URL_PREFIX = "http://MICROS-DEPT"; //微服务真实名字
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/insert")
	public Integer insert(User user) {
		return restTemplate.postForObject(REST_URL_PREFIX + "/user/insert", user, Integer.class);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAllUser")
	public List<User> findAllUser(){
		return restTemplate.getForObject(REST_URL_PREFIX + "/user/findAllUser", List.class);
	}
	
	//测试@EnableDiscoveryClient 消费者可以调用服务发现
	@RequestMapping(value = "/discovery")
	public Object discovery() {
		return restTemplate.getForEntity(REST_URL_PREFIX + "/user/discovery", Object.class);
	}
}
