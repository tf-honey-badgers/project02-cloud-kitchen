package org.badgers.customer.model;


import lombok.Data;

@Data
public class OrderPaymentVO {
	private String id; // orderId
	private int amount; // payAmt
	private String method; // input
}
