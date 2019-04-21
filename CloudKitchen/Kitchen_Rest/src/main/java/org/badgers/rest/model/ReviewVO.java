package org.badgers.rest.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReviewVO {
	
	private int revId;
	private int custIdx;
	private int menuId;
	private Timestamp revDate;
	private int stars;
	private String revContent;
	private String bizId;
}
