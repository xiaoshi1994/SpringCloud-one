package com.shi.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="SPRINGCLOUD04-PRODECT-8001",configuration=com.shi.rule.MyselfRule.class)
public class Customer7001 {

	public static void main(String[] args) {
		SpringApplication.run(Customer7001.class, args);
	}

}
