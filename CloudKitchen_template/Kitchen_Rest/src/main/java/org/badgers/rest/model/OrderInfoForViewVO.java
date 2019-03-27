package org.badgers.rest.model;

import java.util.Map;

import lombok.Data;

@Data
public class OrderInfoForViewVO {

	private String id;
	private String bizName;
	private String phone;
	private String address;
	private String time;
	private String status;
	private String kitchenName;
	private String method;
	private String msg;
	private int payAmt;
	private Map<String, OrderInfoMenuForViewVO> menus;
	//(메뉴이름:{옵션이름:가격},{옵션이름:가격}

	public OrderInfoForViewVO() {}
	
	public OrderInfoForViewVO(String id, String bizName, String phone, String address, String time, String status,
			String kitchenName, String method, String msg, int payAmt, Map<String, OrderInfoMenuForViewVO> menus) {
		super();
		this.id = id;
		this.bizName = bizName;
		this.phone = phone;
		this.address = address;
		this.time = time;
		this.status = status;
		this.kitchenName = kitchenName;
		this.method = method;
		this.msg = msg;
		this.payAmt = payAmt;
		this.menus = menus;
	}
	
	
	
	
}
