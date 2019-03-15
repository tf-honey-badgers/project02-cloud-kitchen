package org.badgers.rest.firebasetest;

import lombok.Data;

@Data
public class Order {

	private String customerName;
	private String address;
	private String phone;
	private String requestMSG;
	private Menu[] menu;
}
