package com.shi.core.service;

import java.util.List;

import org.springframework.stereotype.Component;
import com.shi.core.model.Dept;
import feign.hystrix.FallbackFactory;

/**
 * @Component 该注解一定要在customer 容器初始化中被初始化到 不然加载不到该注解，无法初始化该对象，
 * 会报错：No fallbackFactory instance of type
 * @author SHF
 * @version 创建时间：2018年12月3日  下午2:14:06
 */
@Component //不要忘记添加，不要忘记添加，不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable arg0) {
		
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dept get(long id) {
				// TODO Auto-generated method stub
				Dept dept = new Dept();
				dept.setDeptno(id);
				dept.setDname("该数据库中"+id+"还没有改id的存在,Consumer客户端提供的降级信息，此刻服务Provider已经关闭");
				dept.setDb_source("no data_source exit...");
				return dept;
			}
			
			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
