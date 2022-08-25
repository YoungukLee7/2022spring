package com.test.one.pizza.service;

import java.util.List;

import com.test.one.pizza.dto.Pizza;

public interface PizzaService {
	
	public List<Pizza> getList();
	
	public Integer addPizza(Pizza pizza);

	public Pizza updatePizzaForm(int id);
	
	public Integer updatePizza(Pizza pizza);
	
	public Integer deletePizza(int id);
}
