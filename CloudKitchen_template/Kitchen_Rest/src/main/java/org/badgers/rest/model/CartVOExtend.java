package org.badgers.rest.model;

import java.util.List;

import lombok.Data;

// CartVo + list<CartDetailVo>

@Data
public class CartVOExtend {
	private String id;
	private String custId; // FK -> customer 테이블 id 속성 참조
	private int quantity;
	private int unitPrice;
	private int amount;
	private String kitchenName;
	private String bizName;
	private String menuId; // FK -> menu 테이블 id 속성 참조
	private String menuName;
	private int idx;
	
	private List<CartDetailVO> options;
}
