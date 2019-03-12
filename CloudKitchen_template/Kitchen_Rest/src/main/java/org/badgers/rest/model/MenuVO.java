package org.badgers.rest.model;

import lombok.Data;

@Data
public class MenuVO {
	private String code;
	private String name;
	private int basicPrice;
	private String photo;
	private String menuCatCode;
	private int idx;
}
