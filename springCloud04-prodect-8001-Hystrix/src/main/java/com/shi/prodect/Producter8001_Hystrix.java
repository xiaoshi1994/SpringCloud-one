package com.shi.prodect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker //对Hystrix熔断器的支持
public class Producter8001_Hystrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Producter8001_Hystrix.class, args);
	}

}
