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
	
	// GET ������� ������ ���̵�� �Բ� ��û�� ������ �ش� ������ ������ JSON �������� ��ȯ
	
		@GetMapping(value = "/sample/pizza/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Pizza getPizza(@PathVariable Integer id) {
			// ������ ��ȸ��(Į�θ�)�� �ִ�. ��ȸ�� ������ 1�� �����Ѵ�
			return service.getPizza(id);
		}
		
		// PUT������� �Ķ������ ���� �����Ϳ� �Բ� ��û ������ �ش� ���ڸ� db�� �߰�
		
		@PostMapping(value = "/sample/pizza")
		public ResponseEntity<Pizza> insertPizza(@RequestBody Pizza pizza) {
			
			// String�� null�� üũ���ָ� �ȵǰ� �󰪵� ����� �Ѵ�. (�������� null�θ� ����)
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
			
			// ResponseEntity: ���׿� ���� ���ϴ� ������ ���� �� �ִ� (Http���� �ڵ� Ȱ��)

			//ResponseEntity<Pizza> response = null;
			
			// ResponseEntity.ok() : Http �����ڵ� 200�� ������ �����.
			//response = ResponseEntity.ok(null);
			
			// ResponseEntity.notFound() : http �����ڵ� 404�� ������ �����
			//response = ResponseEntity.notFound().build();
			
			// �����Ӱ� ������ �����
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
			
			try {				
				return service.updatePizza(pizza).toString();
			} catch (Exception e) {
				return "0: " + e;
			}
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
