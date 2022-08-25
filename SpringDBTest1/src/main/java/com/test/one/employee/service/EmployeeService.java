package com.test.one.employee.service;

import java.util.List;

import com.test.one.employee.dto.Employee;
import com.test.one.pizza.dto.Pizza;

public interface EmployeeService {
	
	// select
	public List<Employee> getList();
	
	// insert
	public Integer add(Employee employee);

	// update
	public Employee updateForm(int id);
	
	// update
	public Integer update(Employee employee);
	
	// delete
	public Integer delete(Employee employee);


}
