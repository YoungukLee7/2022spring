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
	
	// GET ������� ������ ���̵�� �Բ� ��û�� ������ �ش� ������ ������ JSON �������� ��ȯ
	
		@GetMapping(value = "/pizzaData", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Pizza getPizzaData() {
			Pizza pizza = new Pizza();
			
//			pizza.setPizza_id(13);
//			pizza.setPizza_name("���۷δ�");
//			pizza.setPizza_calories(333.123);
//			pizza.setPizza_price(8000);
			
			return pizza;
		}
		
		// PUT������� �Ķ������ ���� �����Ϳ� �Բ� ��û ������ �ش� ���ڸ� db�� �߰�
		
		// @RestController������ @RequestBody�� �������� ������ �Ķ���Ͱ� �ڵ� ���ε� ���� �ʴ´�
		@PostMapping(value = "/sample/pizza")
		public Integer insertPizza(@RequestBody Pizza pizza) {
			log.info(pizza);
			return 1;
		}
		
		// PUT������� �Ķ������ ���� �����͸� �Բ� ��û ������ �ش� ������ ������ �޾Ƽ� ����
		
		// DELETE ������� ������ ���̵�� �Բ� ��û�� ������ �ش� ���ڸ� db���� ����

}
