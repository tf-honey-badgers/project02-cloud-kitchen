package org.badgers.rest.model;

import lombok.Data;

@Data
public class FavoriteVO {
	private String custId;
	private String bizId;
	private String bizName;
	private String kitchenName;
}