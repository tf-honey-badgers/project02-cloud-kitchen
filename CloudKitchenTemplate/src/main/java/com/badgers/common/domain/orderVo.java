package com.badgers.common.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class orderVo {
	// Table : order
	private String code;
	private String phone;
	private String msg;
	private int total_amt;
	private int use_point;
	private int pay_amt;
	private String status;
	private Timestamp time;
	private String kitchen_name;
	private String cust_id;
	// Table : order_detail (주문 상세 정보)
	private String no;
	private int quantity;
	private int total_amount;
	private int menu_price;
	private String biz_name;
	private String biz_id;
	private String menu_code;
	private String request_msg;
	// Table : order_menu_option (주문 옵션 정보)
	private String id;
	private String name;
	private int opt_price;
	private String opt_code;
}
