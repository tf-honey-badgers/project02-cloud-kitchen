package org.badgers.business.model;


import lombok.Data;

@Data
public class OrderVO {
	
	private String id;
	private String custId;
	private String phone;
	private String address;
	private String msg;
	private String kitchenName;
	private int payAmt;
	private String status;
	
}
