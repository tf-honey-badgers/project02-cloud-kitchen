package com.badgers.common.domain;

import lombok.Data;

@Data
public class CartVo {
	// Table : cart
	private String code;
	private String custId;
	private int quantity;
	private int unitPrice;
	private int amount;
	private String kitchenName;
	private String bizName;
	// Table : cart_detail
	private CartDetailVo detailVo;
	// Table : menu
	private MenuVo menuVo;
}
