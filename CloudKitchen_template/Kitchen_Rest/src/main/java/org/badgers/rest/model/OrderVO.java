package org.badgers.rest.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderVO {
	
	private String id;
	private String phone;
	private String address;
	private String msg;
	private int payAmt;
	private String status;
	private String time;
	private String kitchenName;
	private String custId;
	
	public OrderVO() {
	}
	
	public OrderVO(String id, String phone, String address, String msg, int payAmt, String status, String time,
			String kitchenName, String custId) {
		super();
		this.id = id;
		this.phone = phone;
		this.address = address;
		this.msg = msg;
		this.payAmt = payAmt;
		this.status = status;
		this.time = time;
		this.kitchenName = kitchenName;
		this.custId = custId;
	}


}
