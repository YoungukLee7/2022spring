package com.ezen.restful.mapper;

import java.util.List;

import com.ezen.restful.dto.Pizza;

public interface PizzaMapper {
	
	// ���� �ϳ� ��������
	Pizza get(int pk);
	
	// ��ȸ�� �ø��� (Į�θ��� ��� �ø�)
	Integer updateView(int pk);
	
	// ���� ��ü ��ȸ�ϱ�
	List<Pizza> getAll();
	
	Integer update(Pizza pizza);
	
	Integer insert(Pizza pizza);

}
