package com.xcy.springcloud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.xcy.springcloud.model.User;

import feign.hystrix.FallbackFactory;
@Component
public class UserClientServiceFallbackFactory implements FallbackFactory<UserClientService> {

	@Override
	public UserClientService create(Throwable cause) {
		return new UserClientService() {
			
			@Override
			public Integer insert(User user) {
				return null;
			}
			
			@Override
			public List<User> findAllUser() {
				List<User> list = new ArrayList<>();
				User u =new User();
				u.setId(1);
				u.setUsername("admin");
				u.setPassword("123456");
				list.add(u);
				return list;
			}
		};
	}

}
