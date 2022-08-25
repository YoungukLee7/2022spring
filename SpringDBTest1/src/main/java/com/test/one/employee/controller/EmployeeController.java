package com.test.one.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.one.employee.service.EmployeeService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;

	@GetMapping("lists")
	public void list(Model model) {
		//model.addAttribute("list", service.getList());
	}
}
