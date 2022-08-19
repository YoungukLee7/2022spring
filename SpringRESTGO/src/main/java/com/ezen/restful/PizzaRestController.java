package com.ezen.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	// GET ������� ������ ���̵�� �Բ� ��û�� ������ �ش� ������ ������ JSON �������� ��ȯ
	
		@GetMapping(value = "/sample/pizza/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Pizza getPizza(@PathVariable Integer id) {
			// ������ ��ȸ��(Į�θ�)�� �ִ�. ��ȸ�� ������ 1�� �����Ѵ�
			return service.getPizza(id);
		}
		
		// PUT������� �Ķ������ ���� �����Ϳ� �Բ� ��û ������ �ش� ���ڸ� db�� �߰�
		
		@PostMapping(value = "/sample/pizza")
		public Integer insertPizza(@RequestBody Pizza pizza) {
			// ReaponseEntity: ���׿� ���� ���ϴ� ������ ���� �� �ִ� (���� �ڵ� Ȱ��)
			//ReaponseEntity<Pizza>
			
			try {				
				return service.insertPizza(pizza);
			} catch (Exception e) {
				return -1;
			}
			
		}
		
		// @RestController������ @RequestBody�� �������� ������ �Ķ���Ͱ� �ڵ� ���ε� ���� �ʴ´�
//		@PostMapping(value = "/sample/pizza")
//		public Integer putPizza(@RequestBody Pizza pizza) {
//			log.info(pizza);
//			return 3;
//		}
		
		// PUT������� �Ķ������ ���� �����͸� �Բ� ��û ������ �ش� ������ ������ �޾Ƽ� ����
		
		@PutMapping(value = "/sample/pizza", produces = MediaType.TEXT_PLAIN_VALUE)
		public String updatePizza(@RequestBody Pizza pizza) {
			//log.info("���� ����: " + pizza);
			
//			try {				
				return service.updatePizza(pizza).toString();
//			} catch (Exception e) {
//				return "0: " + e;
//			}
		}
		
		// DELETE ������� ������ ���̵�� �Բ� ��û�� ������ �ش� ���ڸ� db���� ����
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
