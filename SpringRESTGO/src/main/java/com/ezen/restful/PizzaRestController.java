package com.ezen.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.restful.dto.Pizza;
import com.ezen.restful.service.PizzaService;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
public class PizzaRestController {
	
	@Autowired
	PizzaService service;
	
	// GET 방식으로 피자의 아이디와 함께 요청을 보내면 해당 피자의 정보를 JSON 형식으로 반환
	
		@GetMapping(value = "/sample/pizza/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Pizza getPizza(@PathVariable Integer id) {
			// 피자의 조회수(칼로리)가 있다. 조회할 때마다 1씩 증가한다
			return service.getPizza(id);
		}
		
		// PUT방식으로 파라미터의 피자 데이터와 함께 요청 보내면 해당 피자를 db에 추가
		
		@PostMapping(value = "/sample/pizza")
		public ResponseEntity<Pizza> insertPizza(@RequestBody Pizza pizza) {
			
			// String은 null만 체크해주면 안되고 빈값도 봐줘야 한다. (나머지는 null로만 가능)
			if (pizza.getPizza_name() == null || pizza.getPizza_name().trim().equals("") || 
				pizza.getPizza_calories() == null || pizza.getPizza_price() == null) {
				return ResponseEntity.badRequest().build();
			}
			
			try {
				service.insertPizza(pizza);
				return ResponseEntity.ok().build();
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.build();
			}
			
			// ResponseEntity: 상항에 따라 원하는 응답을 만들 수 있다 (Http상태 코드 활용)

			//ResponseEntity<Pizza> response = null;
			
			// ResponseEntity.ok() : Http 상태코드 200의 응답을 만든다.
			//response = ResponseEntity.ok(null);
			
			// ResponseEntity.notFound() : http 상태코드 404의 응답을 만든다
			//response = ResponseEntity.notFound().build();
			
			// 자유롭게 응답을 만들기
//			response = ResponseEntity.status(HttpStatus.OK)
//					.contentType(MediaType.APPLICATION_JSON)
//					.body(service.getPizza(3));
//			
//			return response;
			
//			try {				
//				return service.insertPizza(pizza);
//			} catch (Exception e) {
//				return -1;
//			}
			
		}
		
		// @RestController에서는 @RequestBody를 적어주지 않으면 파라미터가 자동 바인딩 되지 않는다
//		@PostMapping(value = "/sample/pizza")
//		public Integer putPizza(@RequestBody Pizza pizza) {
//			log.info(pizza);
//			return 3;
//		}
		
		// PUT방식으로 파라미터의 피자 데이터를 함께 요청 보내면 해당 피자의 정보를 받아서 수정
		
		@PutMapping(value = "/sample/pizza", produces = MediaType.TEXT_PLAIN_VALUE)
		public String updatePizza(@RequestBody Pizza pizza) {
			//log.info("받은 피자: " + pizza);
			
			try {				
				return service.updatePizza(pizza).toString();
			} catch (Exception e) {
				return "0: " + e;
			}
		}
		
		// DELETE 방식으로 피자의 아이디와 함께 요청을 보내면 해당 피자를 db에서 삭제
//		@DeleteMapping(value = "/sample/pizza/{id}")
//		public 
		
		@GetMapping(value = "/sample/pizzas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Pizza> getAllPizza() {
			
			List<Pizza> pizza = service.getAllPizza();
			
			pizza.get(1).getPizza_name();
			pizza.get(1).getPizza_price();
			pizza.get(1).getPizza_calories();

			
			return pizza;
		}
}
