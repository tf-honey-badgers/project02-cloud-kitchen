package com.badgers.common.domain;

import java.util.List;

import lombok.Data;

@Data
public class OrderDetailVo {
	// Table : order_detail (주문 상세 정보)
	private String no;
	private int quantity;
	private int totalAmt;
	private int menuPrice;
	private String bizName;
	private String bizId;
	private String menuCode;
	private String requestMsg;
	// Table : order_menu_option (주문 옵션 정보)
	private List<OrderOptionVo> optionList;
}
