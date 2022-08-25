package com.test.one.pizza.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {
	
	private Integer pizza_id;
	private String pizza_name;
	private Integer pizza_price;
	private Double pizza_calories;

}
