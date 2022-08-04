package com.ezen.springmvc.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.springmvc.model.Coffee;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping(value = {"/hello","/hi","/welcome"})
@Controller
public class HelloController {
	
	@RequestMapping(
			value = "/news",
			method = {RequestMethod.GET, RequestMethod.POST})
	public String news() {
		log.info("���� ��Ʈ�ѷ��� �� ������");
		
		// �������� ����ڿ��� �������� �� view�� �̸��� ���ڿ��� �����Ѵ�.
		// ������ ���ڿ� �տ��� /WEB-INF/views �� �ٰ�
		// �ڿ��� .jsp�� �پ ���� ���� ��θ� �ϼ��Ѵ�.
		// ���� ���ؽ�Ʈ.xml�� �� �Ʒ� beans:property�� ���� �� �� �ִ�.
		return "hello/news";
	}
	
	@GetMapping("/blog")
	public String blog() {
		return "hello/blog";
	}
	
	@GetMapping("/coffee/add")
	public String coffeeAddForm() {
		return "coffee/addMenu";
	}
	
	@PostMapping("/coffee/add1")
	 public String coffeeAdd(HttpServletRequest request) throws UnsupportedEncodingException {
		log.info("Ŀ�� �����Ͱ� �����ϴ� ��");
		
		// �ѱ۷� ������ �ϱ�
		request.setCharacterEncoding("EUC-KR");
		
		// ��Ʈ����Ʈ�� �Ƿ����� ����
		log.info("coffee add1 (�ڵ� ���ε��� ������� ����)");
		
		log.info("coffee name : " + request.getParameter("name"));
		log.info("coffee price : " + request.getParameter("price"));
		log.info("coffee hot : " + request.getParameter("hot"));
		
		// ��Ʈ����Ʈ�� ���� �־���
		request.setAttribute("coffee", new Coffee(
				request.getParameter("name"),
				Integer.parseInt(request.getParameter("prise")),
				Boolean.parseBoolean(request.getParameter("hot"))
				));
		
		return "home";
	}
	
	@PostMapping("/coffee/add2")
	 public String coffeeAdd(Coffee coffee) 
			throws UnsupportedEncodingException {
		log.info("Ŀ�� �����Ͱ� �����ϴ� ��");
		
		
		// ��Ʈ����Ʈ�� �Ƿ���
		log.info("coffee add2 (�ڵ� ���ε��� �����)");
		
		log.info(coffee);
		
		if (coffee.isHot()) {
			log.info("�߰ſ� Ŀ�ǰ� �߰��Ǿ����ϴ�.");
		} else {
			log.info("������ Ŀ�ǰ� �߰��Ǿ����ϴ�.");			
		}
		
		return "home";
	}
	
	@PostMapping("/coffee/add3")
	public String coffeeAdd3(
			@ModelAttribute("name") String a, 
			@ModelAttribute("price") Integer b, 
			@ModelAttribute("hot") Boolean c) {
		log.info(a);
		log.info(b);
		log.info(c);
		
		return "home";
	}
	
	@RequestMapping(value = "/garden" , method = RequestMethod.GET)
	public void garden() {
		log.info("garden controller");
	}
	
	@GetMapping(value = "/redirect")
	public String redirect() {
		return "redirect:/hello/coffee/add";
	}
	
}






