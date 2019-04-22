package com.xcy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient //客户端
@EnableFeignClients("com.xcy.springcloud")
@ComponentScan("com.xcy.springcloud")
public class UserConsumerApp {

	public static void main(String[] args) {
		SpringApplication.run(UserConsumerApp.class, args);
	}
}
