package org.badgers.rest.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderPaymentVO {
	private String id;
	private int amount;
	private String method;
	private String time;
}
