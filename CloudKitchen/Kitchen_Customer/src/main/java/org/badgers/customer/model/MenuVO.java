package org.badgers.customer.model;

import lombok.Data;

@Data
public class MenuVO {
	private String code;
	private String name;
	private int basicPrice;
	private String menuCatCode;
}
