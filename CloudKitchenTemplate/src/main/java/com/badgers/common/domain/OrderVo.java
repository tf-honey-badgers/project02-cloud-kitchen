package com.badgers.common.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderVo {
	// Table : order
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
	// Table : order_detail (주문 상세 정보)
	private OrderDetailVo detailVo;
}
