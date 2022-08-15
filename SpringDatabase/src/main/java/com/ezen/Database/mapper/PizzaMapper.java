package com.ezen.Database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ezen.Database.dto.Pizza;

public interface PizzaMapper {
	
	@Select("select * from pizza")
	public List<Pizza> getList();
	
	@Select("INSERT INTO pizza VALUES (pizza_seq.nextval, #{name}, #{price}, #{col})")
	public Pizza insert(
			@Param("name")String name, 
			@Param("price")Integer price, 
			@Param("col")Double col);
	
	@Select("SELECT * FROM pizza where pizza_id = #{id}")
	public Pizza findId(@Param("id")Integer id);
	
}
