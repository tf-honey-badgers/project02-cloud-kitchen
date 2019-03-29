package org.badgers.customer.model;

import lombok.Data;

@Data
public class FavoriteVO {
	private String custId;
	private String bizId;
	private String bizName;
	private int stars;
	private String kitchenName;
	private int bizLikeCnt;
}
