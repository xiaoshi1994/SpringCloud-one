package com.shi.core.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shi.core.model.Dept;
/**
 * 让该接口实现熔断机制，让该接口在使用的中远程调用出错就调用 DeptClientServiceFallbackFactory 中指定的方法
 * @author SHF
 * @version 创建时间：2018年12月3日  上午10:36:25
 */
//@FeignClient(value = "SPRINGCLOUD04-PRODECT-8001")
@FeignClient(name = "SPRINGCLOUD04-PRODECT-8001",fallbackFactory = DeptClientServiceFallbackFactory.class) //指定为哪个微服务提供接口
public interface DeptClientService
{
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") long id);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list();

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(Dept dept);
}
