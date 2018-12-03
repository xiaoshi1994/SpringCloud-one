package com.shi.customer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;

@Configuration
public class RestTemplateConfig {
	
	@Bean
	@LoadBalanced  //开启负载均衡的工具
	public RestTemplate getRestTemlate() {
		return new RestTemplate();
	}
	
	/**
	 * 自指定负载均衡算法
	 * @author SHF
	 * @version 创建时间：2018年11月29日  下午6:04:28
	 *  @return
	 */
	@Bean
	public IRule myselfRule() {
		//return new RoundRobinRule();//使用随机数进行负载均衡
		return new com.shi.rule.MyselfRule();//使用自定义的负载均衡算法
	}
}
