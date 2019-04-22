package com.xcy.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xcy.springcloud.model.User;

@Mapper
public interface UserDao {
	
	int insert(@Param("user")User user);
	
	List<User> findAllUser();

}
