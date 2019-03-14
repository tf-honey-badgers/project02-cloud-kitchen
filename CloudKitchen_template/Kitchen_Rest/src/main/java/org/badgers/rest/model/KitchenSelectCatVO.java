package org.badgers.rest.model;

import lombok.Data;

@Data
public class KitchenSelectCatVO {
	
	private String bizId;
	private String bizInfo;
	private String bizName;
	private int bizLikeCnt;
	private String bizCatId;
	private int bizIdx;
	private String comId;
	private String comName;
	private String comDisc;
	private int comIdx;
}
