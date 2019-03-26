package org.badgers.customer.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class OrderInfoVO {
	private String id;
	private String custId;
	private String orderdetailId;
	private String phone;
	private String address;
	private String time;
	private String statusCode;
	private String status;
	private String kitchenName;
	private String bizId;
	private String bizName; 
	private String method; 
	private String menuName;
	private int menuPrice;
	private String optName;
	private int optPrice;
	private int quantity;
	private int totalAmt;
	private int payAmt;
	private String msg;

	
	/* 파이어베이스 알람 VO */
		public OrderAlarmVO toOrderAlarmVO() {
			StringBuffer optName = new StringBuffer();
			optName.append(this.optName);
			OrderAlarmMenuVO menu = new OrderAlarmMenuVO(this.menuName, optName, this.quantity);
			return new OrderAlarmVO(this.id, this.address, this.time, this.statusCode, this.status, this.msg, menu);
		}
		
		public OrderAlarmMenuVO toOrderAlarmMenuVO() {
			StringBuffer optName = new StringBuffer();
			optName.append(this.optName);
			return new OrderAlarmMenuVO(this.menuName, optName, this.quantity);
		}
		
	/* 사용자 주문 확인 VO */
		public OrderInfoForViewVO toOrderInfoForViewVO() {
			Map<String, OrderInfoMenuForViewVO> menus = new HashMap<>();
			menus.put(this.menuName, toOrderInfoMenuForViewVO());
			
			return new OrderInfoForViewVO(this.id, this.bizName, this.phone, this.address, this.time, this.status, this.kitchenName, this.method, this.msg, this.payAmt, menus);
		}
		
		public OrderInfoMenuForViewVO toOrderInfoMenuForViewVO() {
			Map<String, Integer> option = new HashMap<>();
			option.put(this.optName, this.optPrice);
			
			return new OrderInfoMenuForViewVO(this.menuPrice, this.quantity, this.totalAmt, option);
		}
		
}
