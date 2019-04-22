package com.xcy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启actuator监控注解
public class UserProvider_hystrix_dashboard_App {
	
	public static void main(String[] args) {
		SpringApplication.run(UserProvider_hystrix_dashboard_App.class, args);
	}

}
