package com.ezen.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.Database.dto.Employee;
import com.ezen.Database.mapper.EmployeeMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/employee")
@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeMapper mapper;
	
	// 사원 목록을 모두 조회해야하는 여러가지 서비스
	// - 사원 해고 페이지
	// - 사원 월급 조정 페이지
	// - 사원 직위 조정 페이지 
	
	@GetMapping("/fire")
	public void fire(Model model) {
		for (Employee emp : mapper.getList()) {
			log.info(emp.getFirst_name() + " " + emp.getLast_name());
		}
	}

	@GetMapping("/list")
	public void list(Model model) {
//		List<Employee> employees = new ArrayList<>();
//	
//		try (
//				Connection conn = ds.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
//				ResultSet rs = pstmt.executeQuery();
//		){
//			while (rs.next()) {
//				employees.add(new Employee(rs));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		model.addAttribute("employees", employees);
		model.addAttribute("employees", mapper.getList());
		
	}
}
