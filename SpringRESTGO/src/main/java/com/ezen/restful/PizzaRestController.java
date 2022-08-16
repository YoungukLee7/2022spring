package com.ezen.restful;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.restful.dto.Pizza;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
public class PizzaRestController {
	
	// GET 방식으로 피자의 아이디와 함께 요청을 보내면 해당 피자의 정보를 JSON 형식으로 반환
	
		@GetMapping(value = "/pizzaData", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Pizza getPizzaData() {
			Pizza pizza = new Pizza();
			
//			pizza.setPizza_id(13);
//			pizza.setPizza_name("패퍼로니");
//			pizza.setPizza_calories(333.123);
//			pizza.setPizza_price(8000);
			
			return pizza;
		}
		
		// PUT방식으로 파라미터의 피자 데이터와 함께 요청 보내면 해당 피자를 db에 추가
		
		// @RestController에서는 @RequestBody를 적어주지 않으면 파라미터가 자동 바인딩 되지 않는다
		@PostMapping(value = "/sample/pizza")
		public Integer insertPizza(@RequestBody Pizza pizza) {
			log.info(pizza);
			return 1;
		}
		
		// PUT방식으로 파라미터의 피자 데이터를 함께 요청 보내면 해당 피자의 정보를 받아서 수정
		
		// DELETE 방식으로 피자의 아이디와 함께 요청을 보내면 해당 피자를 db에서 삭제

}
