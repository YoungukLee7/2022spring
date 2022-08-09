package com.ezen.Database.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

// Mybatis�� �̿��ؼ� CRUD(����,��ȸ,����,����)�� �����غ�����

@NoArgsConstructor
@Data
public class Pizza {

	private Integer pizza_id;
	private String pizza_name;
	private Integer pizza_price;
	private Double pizza_calories;
}
