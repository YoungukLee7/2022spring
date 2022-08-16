package com.ezen.restful;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.restful.dto.Pizza;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
public class RestSampleController {
	
	// Rest 연습
	
	@GetMapping(value = "/test1", produces = "text/plain; charset=EUC-KR")
	public String test1() {
		return "Hello RestFul!!";
	}
	
	// jackson-databind : 자바 객체를 JSON타입 또는 XML타입으로 알아서 변환해주는 라이브러리
	@GetMapping(value = "/pizza", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Pizza getPizza() {
		Pizza pizza = new Pizza();
		
		pizza.setPizza_id(13);
		pizza.setPizza_name("패퍼로니");
		pizza.setPizza_calories(333.123);
		pizza.setPizza_price(8000);
		
		return pizza;
	}
	
	@GetMapping(value = "/pizza2", produces = MediaType.APPLICATION_XML_VALUE)
	public Pizza getPizza2() {
		Pizza pizza = new Pizza();
		
		pizza.setPizza_id(13);
		pizza.setPizza_name("패퍼로니");
		pizza.setPizza_calories(333.123);
		pizza.setPizza_price(8000);
		
		return pizza;
	}
	
	@GetMapping(value = "/pizzas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Pizza> getPizzas() {
		List<Pizza> pizzas = new ArrayList<>();
		
		pizzas.add(new Pizza(1001,"파인애플 피자",12000,1560.80));
		pizzas.add(new Pizza(1002,"민트초코 피자",13000,1660.80));
		pizzas.add(new Pizza(1003,"페퍼민트 피자",13300,1760.80));
		pizzas.add(new Pizza(1004,"보약 피자",14000,1860.80));
		
		return pizzas;
	}
	
	
	@GetMapping(value = "/pizza_map", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Pizza> getPizzaMap() {
		
		Map<String, Pizza> pizzaMap = new HashMap<>();
		
		pizzaMap.put("menu1", new Pizza(1001, "하리보 피자", 12000, 1560.80));
		pizzaMap.put("menu2", new Pizza(1001, "개피맛 피자", 13000, 1560.80));
		pizzaMap.put("menu3", new Pizza(1001, "바나나 피자", 14000, 1560.80));
		
		return pizzaMap;
	}
}
