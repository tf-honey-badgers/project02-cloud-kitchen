package com.badgers.common.domain;

import lombok.Data;

@Data
public class MenuOptionVo {
	// Table : menu_option
	private String code;
	private String name;
	private int addPrice;
	// Table : menu_option_cl
	private MenuOptionClVo optionClVo;
}
