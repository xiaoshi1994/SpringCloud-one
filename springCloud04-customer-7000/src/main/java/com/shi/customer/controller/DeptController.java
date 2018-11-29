package com.shi.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.shi.core.model.Dept;

import antlr.collections.List;

@Controller
public class DeptController {
	
	//private static final String REST_URL_PREFIX = "http://127.0.0.1:8001";
	private static final String REST_URL_PREFIX = "http://SPRINGCLOUD04-PRODECT-8001";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/consumer/dept/add")
	@ResponseBody
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, boolean.class);
	}
	
	@GetMapping("/consumer/dept/get/{id}")
	@ResponseBody
	public Object get(@PathVariable("id") Integer id) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Object.class);
	}
	
	@GetMapping("/consumer/dept/list")
	@ResponseBody
	public Object list(){
		Object list = restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", Object.class);
		return list;
	}
	
	//测试@EnableDiscoveryClient，消费端可以调用服务发现
	@GetMapping("/consumer/dept/discovery")
	public Object discover() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
	}
	
}
