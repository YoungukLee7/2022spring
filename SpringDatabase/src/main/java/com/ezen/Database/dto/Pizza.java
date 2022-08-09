package com.ezen.Database.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

// Mybatis를 이용해서 CRUD(생성,조회,수정,삭제)를 구현해보세요

@NoArgsConstructor
@Data
public class Pizza {

	private Integer pizza_id;
	private String pizza_name;
	private Integer pizza_price;
	private Double pizza_calories;
}
