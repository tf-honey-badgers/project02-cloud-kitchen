package org.badgers.domain;

import lombok.Data;

@Data
public class FavoriteVo {
	private String custId;
	private String bizId;
	private String bizName;
	private int stars;
	private String kitchenName;
}
