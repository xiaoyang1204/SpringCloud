package com.xcy.springcloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xcy.springcloud.model.User;
import com.xcy.springcloud.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService = null;
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value = "/insert" , method = RequestMethod.POST)
	public Integer insertUser(@RequestBody User user) {
		return userService.insert(user);
	}
	
	@RequestMapping("/findAllUser")
	//一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的制定方法
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public List<User> findAllUser(){
		String s = null;
		if(s == null) {
			throw new RuntimeException("未查到");
		}
		System.out.println("111111111111111111111");
		 List<User> list = userService.findAllUser();
		 
		 return list;
	}
	
	public List<User> processHystrix_Get() {
		List<User> list = new ArrayList<>();
		User u =new User();
		u.setId(1);
		u.setUsername("admin");
		u.setPassword("123456");
		list.add(u);
		return list;
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
