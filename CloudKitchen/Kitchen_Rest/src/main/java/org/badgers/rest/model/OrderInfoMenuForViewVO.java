package org.badgers.rest.model;

import java.util.Map;

import lombok.Data;

@Data
public class OrderInfoMenuForViewVO {

//	private String menuName;
	private int menuPrice;
	private int quantity;
	private int totalAmt;
	private Map<String, Integer> option;
//	private String optName;
//	private int optPrice;

	public OrderInfoMenuForViewVO() {
	}

	public OrderInfoMenuForViewVO(int menuPrice, int quantity, int totalAmt, Map<String, Integer> option) {
		super();
		this.menuPrice = menuPrice;
		this.quantity = quantity;
		this.totalAmt = totalAmt;
		this.option = option;
	}

}
