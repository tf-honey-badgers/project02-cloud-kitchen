package org.badgers.rest.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderVO {
	private String id;
	private String phone;
	private String msg;
	private int payAmt;
	private String status;
	private Timestamp time;
	private String kitchenName;
	private String custId;
}
