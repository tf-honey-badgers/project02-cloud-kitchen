package org.badgers.rest.model;

import lombok.Data;

@Data
public class BizVOExtend {
	private String bizId;
	private String bizInfo;
	private String bizName;
	private int bizLikeCnt;
	private int bizMinAmt;
	private String bizCatId;
	private String bizKitchenId;
	private MenuCatVOExtend bizMenucatvo;
	private int bizIdx;
}
