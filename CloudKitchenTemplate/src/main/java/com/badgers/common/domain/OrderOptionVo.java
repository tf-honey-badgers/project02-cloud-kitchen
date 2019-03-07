package com.badgers.common.domain;

import lombok.Data;

@Data
public class OrderOptionVo {
	// Table : order_menu_option (주문 옵션 정보)
	private String id;
	private String name;
	private int optPrice;
	private String optCode;
}
