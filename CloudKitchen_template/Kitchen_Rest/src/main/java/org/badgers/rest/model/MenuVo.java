package org.badgers.rest.model;

import lombok.Data;

@Data
public class MenuVo {
	private String code;
	private String name;
	private int basicPrice;
	private String menuCatCode;
}
