package com.shi.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shi.core.model.Dept;
import com.shi.core.service.DeptClientService;

@Controller
public class DeptController {
	
	@Autowired
	private DeptClientService deptClientService;
	
	@GetMapping("/consumer/dept/add")
	@ResponseBody
	public boolean add(Dept dept) {
		return deptClientService.add(dept);
	}
	
	@GetMapping("/consumer/dept/get/{id}")
	@ResponseBody
	public Object get(@PathVariable("id") Integer id) {
		return deptClientService.get(id);
	}
	
	@GetMapping("/consumer/dept/list")
	@ResponseBody
	public Object list(){
		Object list = deptClientService.list();
		return list;
	}
	
}
