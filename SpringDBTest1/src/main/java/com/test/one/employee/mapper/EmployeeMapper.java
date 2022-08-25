package com.test.one.employee.mapper;

import java.util.List;

import com.test.one.employee.dto.Employee;

public interface EmployeeMapper {
	
	 // select
	 public List<Employee> getList();
	 
	 // insert
	 public int add(Employee employee);
	 
	 // update
	 public Employee updateId(int id);
	 public int update(Employee employee);
	 
	 // delete
	 public int delete(Employee employee);

}
