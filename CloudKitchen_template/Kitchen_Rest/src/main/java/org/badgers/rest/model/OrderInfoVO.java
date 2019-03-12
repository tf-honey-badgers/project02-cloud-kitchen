package org.badgers.rest.model;

import lombok.Data;

@Data
public class OrderInfoVO {
	private String id;
	private String phone;
	private String msg;
	private int payAmt;
	private String status;
	private String time;
	private String kitchenName;
	private String custId;
	private String orderDetailId;
	private int quantity;
	private int menuPrice;
	private int addOptionPrice;
	private int totalAmt;
	private String bizName; 
	private String orderOptId;
	private	String orderOptName;
	private int optPrice;
	private String optId;

}
