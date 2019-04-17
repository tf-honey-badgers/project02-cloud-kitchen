package org.badgers.customer.model;


import lombok.Data;

@Data
public class OrderVO {
	
	private String id;
	private String custId;
	private String phone;
	private String address;
	private String time;
	private String msg;
	private String kitchenName;
	private int payAmt;
	private String status;
	
}
