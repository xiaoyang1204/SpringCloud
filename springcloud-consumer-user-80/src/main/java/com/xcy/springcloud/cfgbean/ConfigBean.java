package com.xcy.springcloud.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class ConfigBean {//boot --> Spring

	@Bean
	@LoadBalanced //Spring Cloud Ribbon 是基于Netflix Ribbon 实现的一套客户端 负载均衡的工具。
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	//Ribbon 提供了多种策略：比如轮询、随机和根据响应时间加权。
	@Bean
	public IRule myRule() {
//		return new RoundRobinRule(); //轮询
		return new RandomRule(); //随机
//		return new RetryRule();
	}
}