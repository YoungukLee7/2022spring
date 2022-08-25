package com.test.one.pizza.mapper;

import java.util.List;

import com.test.one.pizza.dto.Pizza;

public interface PizzaMapper {
	
	 public List<Pizza> getList();

	 public int add(Pizza pizza);
	 
	 public int getIdByName(Pizza pizza);
	 
	 public Pizza getPizza(int id);
	 
	 public int update(Pizza pizza);
	 
}
