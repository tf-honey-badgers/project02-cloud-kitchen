package com.badgers.common.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PaymentVo {
	// Table : order_payment
	private String payId;
	private int payAmount;
	private String payMethod;
	private Timestamp payTime;
	private String order_code;
}