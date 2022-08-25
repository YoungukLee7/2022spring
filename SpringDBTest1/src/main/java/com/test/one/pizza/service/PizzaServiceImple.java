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
		// pizza name�� unique�� �ɷ��ִٰ� ����
		
		// 1. ���ڸ� �߰��Ѵ�
		int row = pizzaMapper.add(pizza);
		
		// 2. ��� �߰��� ������ ���̵�� �𸣴ϱ� (�������ϱ�) �̸��� ���� �ٽ� �����´�
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
		// pizza �������� ���� �˻�..(���⼭ ��)

		return pizzaMapper.update(pizza);
	}



}
