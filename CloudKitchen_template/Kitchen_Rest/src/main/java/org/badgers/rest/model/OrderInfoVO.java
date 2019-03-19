package org.badgers.rest.model;

import lombok.Data;

@Data
public class OrderInfoVO {
	private String id;
	private String custId;
	private String orderdetailId;
	private String phone;
	private String address;
	private String time;
	private String statusCode;
	private String status;
	private String kitchenName;
	private String bizId;
	private String bizName; 
	private String method; 
	private String menuName;
	private int menuPrice;
	private String optName;
	private int optPrice;
	private int quantity;
	private int totalAmt;
	private int payAmt;
	private String msg;
	private String requestMsg;

}
