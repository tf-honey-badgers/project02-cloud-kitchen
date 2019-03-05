package com.badgers.common.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class paymentVo {
	// Table : order_payment
	private String pay_id;
	private int pay_amount;
	private String pay_method;
	private Timestamp pay_time;
}