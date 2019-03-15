package org.badgers.rest.model;


import lombok.Data;

@Data
public class OrderPaymentVO {
	private String id;
	private int amount;
	private String method;
}
