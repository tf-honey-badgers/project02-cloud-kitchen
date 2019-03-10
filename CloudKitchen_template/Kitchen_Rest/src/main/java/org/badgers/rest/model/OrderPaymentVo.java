package org.badgers.rest.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderPaymentVo {
	private String id;
	private int amount;
	private String method;
	private Timestamp time;
	private String orderCode;
}
