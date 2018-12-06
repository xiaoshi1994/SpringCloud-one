package com.shi.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 开启服务代理网关配置
 * @author SHF
 * @version 创建时间：2018年12月3日  下午4:16:35
 */
@SpringBootApplication
@EnableZuulProxy
public class SpringZuul_APP_9527 {

	public static void main(String[] args) {
			SpringApplication.run(SpringZuul_APP_9527.class, args);
	}

}
