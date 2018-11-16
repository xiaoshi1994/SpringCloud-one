package com.shi.prodect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Producter8001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Producter8001.class, args);
	}

}
