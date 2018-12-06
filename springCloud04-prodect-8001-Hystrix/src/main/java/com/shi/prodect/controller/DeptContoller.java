package com.shi.prodect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shi.core.model.Dept;
import com.shi.prodect.service.DeptService;

@Controller
public class DeptContoller {
	
	@Autowired
	private DeptService deptService;
	
	/**
	 * 测试使用熔断器Hystrix的使用
	 * @author SHF
	 * @version 创建时间：2018年11月30日  下午4:51:37
	 *  @param id
	 *  @return
	 */
	@GetMapping("/dept/get/{id}")
	@ResponseBody
	//一旦服务调用失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod中指定的方法
	@HystrixCommand(fallbackMethod="Get_DeptError")
	public Dept get(@PathVariable(name="id") Long id) {
		Dept dept = deptService.get(id);
		if(dept == null) {
			throw new RuntimeException("该"+id+"暂时没有对应的信息");
		}
		return dept;
	}
	
	public Dept Get_DeptError(@PathVariable(name="id") Long id) {
		Dept dept = new Dept();
		dept.setDeptno(id);
		dept.setDname("该数据库中"+id+"还没有改id的存在 @HystrixCommand ");
		dept.setDb_source("no data_source exit...");
		return dept;
	}
}
