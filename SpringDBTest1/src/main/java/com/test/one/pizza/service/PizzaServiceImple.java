package com.test.one.pizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.one.pizza.dto.Pizza;
import com.test.one.pizza.mapper.PizzaMapper;

@Service
public class PizzaServiceImple implements PizzaService {

	PizzaMapper pizzaMapper;
	
	@Autowired
	public PizzaServiceImple(PizzaMapper pizzaMapper) {
		this.pizzaMapper = pizzaMapper;
	}
	
	@Override
	public List<Pizza> getList() {
		return pizzaMapper.getList();
	}

	@Override
	public Integer addPizza(Pizza pizza) {
		// pizza name에 unique가 걸려있다고 가정
		
		// 1. 피자를 추가한다
		int row = pizzaMapper.add(pizza);
		
		// 2. 방금 추가한 피자의 아이디는 모르니까 (시퀀스니까) 이름을 통해 다시 가져온다
		if (row > 0) {
			return pizzaMapper.getIdByName(pizza);
		} else {
			return null;
		}
		
	}

	@Override
	public Pizza updatePizzaForm(int id) {
		return pizzaMapper.getPizza(id);
	}

	@Override
	public Integer updatePizza(Pizza pizza) {
		// pizza 수정값에 대한 검사..(여기서 함)

		return pizzaMapper.update(pizza);
	}



}
