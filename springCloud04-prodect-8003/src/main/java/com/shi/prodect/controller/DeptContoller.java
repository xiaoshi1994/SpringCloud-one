package com.shi.prodect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shi.core.model.Dept;
import com.shi.prodect.service.DeptService;

@Controller
public class DeptContoller {
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping("/dept/discovery")
	public Object discovery() {
		List<String> list = client.getServices();
		System.out.println("**********" + list);
		
		List<ServiceInstance> serverList = client.getInstances("SPRINGCLOUD04-PRODECT-8001");
		for(ServiceInstance element : serverList) {
			System.out.println(element.getServiceId() +"\t"+ element.getHost()+"\t"+element.getUri());
		}
		return this.client;
	}
	
	@PostMapping("/dept/add")
	public boolean add(Dept dept) {
		return deptService.add(dept);
	}
	
	@GetMapping("/dept/get/{id}")
	@ResponseBody
	public Dept get(@PathVariable(name="id") Long id) {
		Dept dept = deptService.get(id);
		return dept;
	}
	
	@RequestMapping("/dept/list")
	@ResponseBody
	public List<Dept> get(){
		List<Dept>  list =  deptService.list();
		return list;
	}

}
