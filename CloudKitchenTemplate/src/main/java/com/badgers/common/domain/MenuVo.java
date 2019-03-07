package com.badgers.common.domain;

import lombok.Data;

@Data
public class MenuVo {
	// Table : menu
	private String code;
	private String name;
	private int basicPrice;
	// Table : menu_cat
	private MenuCatVo catVo;
}