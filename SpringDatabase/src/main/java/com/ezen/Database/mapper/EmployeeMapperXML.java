package com.ezen.Database.mapper;

import java.util.List;

import com.ezen.Database.dto.Employee;

public interface EmployeeMapperXML {

	public List<Employee> getList();
	
	public List<Employee> getListByDept(int department_id);
}
