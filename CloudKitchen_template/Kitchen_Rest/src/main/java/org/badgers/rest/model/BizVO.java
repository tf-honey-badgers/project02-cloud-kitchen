package org.badgers.rest.model;

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
	private MenuCatVO menucatvo;
	private int idx;
}
