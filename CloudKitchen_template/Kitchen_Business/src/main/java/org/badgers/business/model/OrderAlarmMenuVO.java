package org.badgers.business.model;

import lombok.Data;

@Data
public class OrderAlarmMenuVO {
	private String menuName;
	private StringBuffer optName;
	private int quantity;

	OrderAlarmMenuVO() {
	}

	OrderAlarmMenuVO(String menuName, StringBuffer optName, int quantity) {
		this.menuName = menuName;
		this.optName = optName;
		this.quantity = quantity;
	}

}
