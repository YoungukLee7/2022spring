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
		log.info("뉴스 컨트롤러에 잘 도착함");
		
		// 다음으로 사용자에게 보여져야 할 view의 이름을 문자열로 리턴한다.
		// 리턴한 문자열 앞에는 /WEB-INF/views 가 붙고
		// 뒤에는 .jsp가 붙어서 다음 뷰의 경로를 완성한다.
		// 서블릿 콘텍스트.xml에 맨 아래 beans:property를 보면 알 수 있다.
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
		log.info("커피 데이터가 도착하는 곳");
		
		// 한글로 나오게 하기
		request.setCharacterEncoding("EUC-KR");
		
		// 어트리뷰트에 실려가지 않음
		log.info("coffee add1 (자동 바인딩을 사용하지 않음)");
		
		log.info("coffee name : " + request.getParameter("name"));
		log.info("coffee price : " + request.getParameter("price"));
		log.info("coffee hot : " + request.getParameter("hot"));
		
		// 어트리뷰트에 직접 넣어줌
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
		log.info("커피 데이터가 도착하는 곳");
		
		
		// 어트리뷰트에 실려감
		log.info("coffee add2 (자동 바인딩을 사용함)");
		
		log.info(coffee);
		
		if (coffee.isHot()) {
			log.info("뜨거운 커피가 추가되었습니다.");
		} else {
			log.info("차가운 커피가 추가되었습니다.");			
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






