package com.xcy.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
/**
 * 自定义Ribbon
 * @author Admin
 *
 */
@Configuration
public class MySelfRule {
	
	@Bean
	public IRule myRule() {
		return new RandomRule();
	}

}
