package com.shi.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //开启eureka服务器端注解 
public class Eureka9000 {

	public static void main(String[] args) {
		SpringApplication.run(Eureka9000.class, args);
	}

}
