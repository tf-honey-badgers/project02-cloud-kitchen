package org.badgers.rest.model;

import lombok.Data;

@Data
public class CartVO {
	private int id;
	private String custId; // FK -> customer 테이블 id 속성 참조
	private int quantity;
	private int unitPrice;
	private int totalAmt;
	private String kitchenName;
	private String bizName;
	private int menuId; // FK -> menu 테이블 idx 속성 참조
}
