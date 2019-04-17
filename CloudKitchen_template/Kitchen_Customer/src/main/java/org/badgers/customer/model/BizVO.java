package org.badgers.customer.model;

import lombok.Data;

@Data
public class BizVO {
	private String bizId;
	private String info;
	private String name;
	private int likeCnt;
	private int minAmt;
	private String bizCatId;
	private String kitchenId;
}
