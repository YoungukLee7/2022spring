package com.ezen.restful.mapper;

import java.util.List;

import com.ezen.restful.dto.Pizza;

public interface PizzaMapper {
	
	// 피자 하나 꺼내오기
	Pizza get(int pk);
	
	// 조회수 올리기 (칼로리를 대신 올림)
	Integer updateView(int pk);
	
	// 피자 전체 조회하기
	List<Pizza> getAll();
	
	Integer update(Pizza pizza);
	
	Integer insert(Pizza pizza);

}
