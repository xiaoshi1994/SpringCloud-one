package com.shi.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.shi.core.model.Dept;

import antlr.collections.List;

@Controller
public class DeptController {
	
	private static final String REST_URL_PREFIX = "http://127.0.0.1:8001";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/consumer/dept/add")
	@ResponseBody
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, boolean.class);
	}
	
	@GetMapping("/consumer/dept/get/{id}")
	@ResponseBody
	public Dept get(@PathVariable("id") Integer id) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}
	
	@GetMapping("/consumer/dept/list")
	@ResponseBody
	public List list(){
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}
	
}
