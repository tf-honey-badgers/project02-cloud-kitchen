package org.badgers.customer.model;

import java.util.List;

import lombok.Data;

// CartVo + list<CartDetailVo>

@Data
public class CartVOExtend {
	private int id;
	private String custId; // FK -> customer 테이블 id 속성 참조
	private int quantity;
	private int unitPrice;
	private int totalAmt;
	private String kitchenName;
	private String bizId;
	private int menuId; // FK -> menu 테이블 id 속성 참조
	private String menuName; // menu 테이블 이름
	private String bizName; // menu 테이블 이름
	
	private List<CartDetailVO> options;
}
