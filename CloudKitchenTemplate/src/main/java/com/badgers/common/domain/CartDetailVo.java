package com.badgers.common.domain;

import lombok.Data;

@Data
public class CartDetailVo {
	// Table : cart_detail
	private String no;
	// Table : menu_option
	private MenuOptionVo optionVo;
}