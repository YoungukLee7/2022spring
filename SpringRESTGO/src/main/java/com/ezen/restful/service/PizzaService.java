package com.ezen.restful.service;

import java.util.List;

import com.ezen.restful.dto.Pizza;

public interface PizzaService {
	
	public Pizza getPizza(int pk);
	
	public List<Pizza> getAllPizza();

}
