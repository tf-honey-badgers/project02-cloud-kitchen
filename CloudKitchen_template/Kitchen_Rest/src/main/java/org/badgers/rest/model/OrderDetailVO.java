package org.badgers.rest.model;

import lombok.Data;

@Data
public class OrderDetailVO {
	private String no;
	private int quantity;
	private int totalAmt;
	private int menuPrice;
	private String bizName;
	private String bizId;
	private String menuCode;
	private String requestMsg;
	private String orderCode;
}
