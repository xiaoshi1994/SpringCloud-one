package com.shi.prodect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //服务发现
public class Producter8003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Producter8003.class, args);
	}

}
