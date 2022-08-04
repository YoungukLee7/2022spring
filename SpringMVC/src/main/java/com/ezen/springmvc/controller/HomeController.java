package com.ezen.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

// 여러 Logger가 있으므로 주위
//import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.springmvc.model.Coffee;
import com.ezen.springmvc.model.shop.Shop;

import lombok.extern.log4j.Log4j2;

//import lombok.extern.log4j.Log4j;


@Log4j2
@Controller
public class HomeController {
	
	
	//private Logger log = Logger.getLogger(this.getClass());
	
	
	@Autowired
	Coffee coffee;
	
	@Autowired
	Shop shop;
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		// 이렇게 안찍고
		// System.out.println("Coffee: " + coffee);
		// System.out.println("Shop: " + shop);
		
		// 이제 이렇게 찍는다.
		// log.error("This is error message");
		// log.info("infomation");
		// log.debug("I am debug message");
		// log.trace("trace message");
		
		log.warn("getAllCustomer");
		log.debug("debug");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("coffee", coffee );
		
		return "home";
	}
	
}
