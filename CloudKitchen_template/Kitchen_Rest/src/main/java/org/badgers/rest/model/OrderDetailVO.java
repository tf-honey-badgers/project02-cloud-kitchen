package org.badgers.rest.model;

import lombok.Data;

@Data
public class OrderDetailVO {
	private String id;
	private String menuId;
	private String menuName;
	private int menuPrice;
	private int addOptionPrice;
	private int quantity;
	private int totalAmt;
	private String bizId;
	private String bizName;
	private String orderId;
	
	public OrderDetailVO() {}

	/*
	 * public OrderDetailVO(String id, int quantity, int menuPrice, int
	 * addOptionPrice, int totalAmt, String bizName, String bizId, String menuCode,
	 * String requestMsg, String orderId) { super(); this.id = id; this.quantity =
	 * quantity; this.menuPrice = menuPrice; this.addOptionPrice = addOptionPrice;
	 * this.totalAmt = totalAmt; this.bizName = bizName; this.bizId = bizId;
	 * this.menuCode = menuCode; this.requestMsg = requestMsg; this.orderId =
	 * orderId; }
	 */

	public OrderDetailVO(int quantity2, int menuPrice2, int addOptionPrice2, int totalAmt2, String bizName2,
			String bizId2, String requestMsg2, String id2) {
		// TODO Auto-generated constructor stub
	}
}
