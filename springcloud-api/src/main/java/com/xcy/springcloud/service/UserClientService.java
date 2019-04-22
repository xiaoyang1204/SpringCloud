package com.xcy.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xcy.springcloud.model.User;


@FeignClient(value = "MICROS-DEPT" , fallbackFactory = UserClientServiceFallbackFactory.class)
public interface UserClientService {
	
	@RequestMapping(value = "/user/findAllUser" , method = RequestMethod.GET)
	public  List<User> findAllUser();

	@RequestMapping(value = "/user/insert" , method = RequestMethod.POST)
	public Integer insert(User user);
	
}
