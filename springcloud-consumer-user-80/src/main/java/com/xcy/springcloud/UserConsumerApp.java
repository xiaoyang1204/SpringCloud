package com.xcy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.xcy.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient //客户端
//在启动该服务的时候就能去加载我们自定义Ribbon配置类，从而使配置生效。
@RibbonClient(name = "MICROS-DEPT" , configuration = MySelfRule.class)
public class UserConsumerApp {

	public static void main(String[] args) {
		SpringApplication.run(UserConsumerApp.class, args);
	}
}
