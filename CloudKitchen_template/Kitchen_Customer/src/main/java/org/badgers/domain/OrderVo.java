package org.badgers.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderVo {
	private String code;
	private String phone;
	private String msg;
	private int totalAmt;
	private int usePoint;
	private int payAmt;
	private String status;
	private Timestamp time;
	private String kitchenName;
	private String custId;
}
