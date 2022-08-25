package com.test.one.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.one.employee.dto.Employee;
import com.test.one.employee.mapper.EmployeeMapper;
import com.test.one.pizza.dto.Pizza;

public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	
	@Override
	public List<Employee> getList() {
		return employeeMapper.getList();
	}

	@Override
	public Integer add(Employee employee) {
		return employeeMapper.add(employee);
	}

	@Override
	public Employee updateForm(int id) {
		return employeeMapper.updateId(id);
	}

	@Override
	public Integer update(Employee employee) {
		return employeeMapper.update(employee);
	}

	@Override
	public Integer delete(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}




}
