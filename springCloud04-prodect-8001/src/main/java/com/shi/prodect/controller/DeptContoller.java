package com.shi.prodect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shi.core.model.Dept;
import com.shi.prodect.service.DeptService;

@RestController
public class DeptContoller {
	
	@Autowired
	private DeptService deptService;
	
	@PostMapping("/dept/add")
	public boolean add(Dept dept) {
		return deptService.add(dept);
	}
	
	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable(name="id") Long id) {
		return deptService.get(id);
	}
	
	@GetMapping("/dept/list")
	public List<Dept> get(){
		return deptService.list();
	}

}
