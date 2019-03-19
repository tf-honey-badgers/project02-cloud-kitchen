package org.badgers.customer.model;

import lombok.Data;

@Data
public class CartVO {
	private String code;
	private String custId;
	private int quantity;
	private int unitPrice;
	private int amount;
	private String kitchenName;
	private String bizName;
	private String menuCode;
}
