package com.shi.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 这是springCloud微服务服务监控者 （豪猪）
 * @author SHF
 * @version 创建时间：2018年12月3日  下午2:46:33
 */
@SpringBootApplication
@EnableHystrixDashboard  //开启豪猪启动注解
public class HystrixDashboard_APP {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboard_APP.class, args);
	}

}
