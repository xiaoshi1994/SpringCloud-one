package com.shi.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.shi.core.service"})//feign服务类的包名
@ComponentScan(basePackages = "com.shi") //一定要保证扫描到core包中@Component 注解
public class Customer7001Feign {

	public static void main(String[] args) {
		SpringApplication.run(Customer7001Feign.class, args);
	}

}
