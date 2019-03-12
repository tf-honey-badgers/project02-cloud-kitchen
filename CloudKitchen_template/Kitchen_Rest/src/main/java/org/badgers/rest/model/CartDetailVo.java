package org.badgers.rest.model;

import lombok.Data;

@Data
public class CartDetailVo {
	private String id;
	private String cartId; // FK -> cart 테이블 id 속성 참조
	private String menuOptId; // FK -> menu_option 테이블 id 속성 참조
	private int idx;
	private String menuId;
	private String menuOptName;
	private int menuOptPrice;
}