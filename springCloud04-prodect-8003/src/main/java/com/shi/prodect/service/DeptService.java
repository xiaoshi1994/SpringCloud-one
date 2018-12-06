package com.shi.prodect.service;

import java.util.List;

import com.shi.core.model.Dept;

public interface DeptService {

	public Boolean add(Dept dept);
	
	public Dept get(Long id);
	
	public List<Dept> list();
	
}
