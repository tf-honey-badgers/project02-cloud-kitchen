package org.badgers.rest.model;

import lombok.Data;

@Data
public class CartVO {
	private String id;
	private String custId; // FK -> customer 테이블 id 속성 참조
	private int quantity;
	private int unitPrice;
	private int amount;
	private String kitchenName;
	private String bizName;
	private String menuCode; // FK -> menu 테이블 id 속성 참조
	private int idx;
	private String menuName;
}
