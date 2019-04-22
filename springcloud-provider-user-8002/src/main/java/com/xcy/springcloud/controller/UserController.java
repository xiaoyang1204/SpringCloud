package com.xcy.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xcy.springcloud.model.User;
import com.xcy.springcloud.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value = "/insert" , method = RequestMethod.POST)
	public Integer insertUser(@RequestBody User user) {
		return userService.insert(user);
	}
	
	@RequestMapping("/findAllUser")
	public List<User> findAllUser(){
		return userService.findAllUser();
	}
	
	/**
	 *    向别人暴露自己
	 * @return
	 */
	@RequestMapping(value = "/discovery" , method = RequestMethod.GET)
	public Object discovery() {
		List<String> list = client.getServices();
		System.out.println("***********" + list);
		
		List<ServiceInstance> serverList = client.getInstances("MICROS-DEPT");
		for (ServiceInstance serviceInstance : serverList) {
			System.out.println(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t" +
					serviceInstance.getPort() + "\t" + serviceInstance.getUri()
					);
		}
		return this.client;
	}
}
