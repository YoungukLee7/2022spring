package com.ezen.Database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ezen.Database.dto.Employee;

public interface EmployeeMapper {
	
	/*
		private Integer employee_id;
		private String first_name;
		private String last_name;
		private Double salary;
		private Double commission_pct;
		private String job_id;
		private Integer department_id;
	 */
	
	@Select("SELECT * FROM employees")
	public List<Employee> getList();
	
	@Select("SELECT * FROM employees where employee_id = #{id}")
	public Employee findbyId(@Param("id")long id);
	
	@Select("SELECT * FROM employees where first_name = #{name}")
	public Employee findbyName(@Param("name")String name);
	
	@Select("SELECT * FROM employees where email = #{email}")
	public Employee findbyEmail(@Param("email")String email);
	

}
