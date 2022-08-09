package com.ezen.Database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ezen.Database.dto.Pizza;

public interface PizzaMapper {
	
	@Select("select * from pizza")
	public List<Pizza> getList();

}
