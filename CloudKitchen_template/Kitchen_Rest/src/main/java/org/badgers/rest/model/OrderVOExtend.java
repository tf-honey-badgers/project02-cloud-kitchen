package org.badgers.rest.model;



import lombok.Data;

@Data
public class OrderVOExtend {
	private String id;
	private String custId;
	private String phone;
	private String address;
	private String msg;
	private String kitchenName;
	private int payAmt;
	private String status;
	private OrderPaymentVO orderPayment;
	private OrderDetailVOExtend[] orderDetails;
}
