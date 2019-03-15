package org.badgers.rest.model;

import lombok.Data;

@Data
public class OrderInfoVO {
	private String id;
	private String phone;
	private String address;
	private String msg;
	private int payAmt;
	private String status;
	private String time;
	private String kitchenName;
	private String custId;
	private String orderDetailId;
	private int quantity;
	private int menuPrice;
	private int addOptionPrice;
	private int totalAmt;
	private String bizName; 
	private String orderOptId;
	private	String orderOptName;
	private int optPrice;
	private String optId;
	private String requestMsg;
	
	public OrderInfoVO(){}

	public OrderInfoVO(
			String id, String phone, String address, String msg, int payAmt, String status, 
			String kitchenName, String custId, String orderDetailId, int quantity, int menuPrice, 
			int addOptionPrice, int totalAmt, String bizName, String orderOptId, String orderOptName, 
			int optPrice, String optId,String requestMsg) 
	{
		super();
		this.id = id;
		this.phone = phone;
		this.address = address;
		this.msg = msg;
		this.payAmt = payAmt;
		this.status = status;
		this.kitchenName = kitchenName;
		this.custId = custId;
		this.orderDetailId = orderDetailId;
		this.quantity = quantity;
		this.menuPrice = menuPrice;
		this.addOptionPrice = addOptionPrice;
		this.totalAmt = totalAmt;
		this.bizName = bizName;
		this.orderOptId = orderOptId;
		this.orderOptName = orderOptName;
		this.optPrice = optPrice;
		this.optId = optId;
		this.requestMsg = requestMsg;
	};


}
