package org.badgers.rest.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReviewVO {
	
	private int rev_id;
	private int cust_idx;
	private int menu_id;
	private Timestamp rev_date;
	private int stars;
	private String rev_content;
}
