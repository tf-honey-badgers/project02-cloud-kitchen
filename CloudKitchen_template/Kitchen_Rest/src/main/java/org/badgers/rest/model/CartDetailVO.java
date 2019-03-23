package org.badgers.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDetailVO {
	private int id;
	private int cartId; // FK -> cart 테이블 id 속성 참조
	private int menuOptId; // FK -> menu_option 테이블 id 속성 참조
	private int menuId; // CartVOExtend의 menuId와 동일
	private String menuOptName;
	private int menuOptPrice;
	
	public CartDetailVO(int optId, int menuId, String optName, int optPrice) {
		this.menuOptId = optId;
		this.menuId = menuId;
		this.menuOptName = optName;
		this.menuOptPrice = optPrice;
	}
}