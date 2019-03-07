package com.badgers.common.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ValidationVo {
	// Table : customer_validation
	private int no;
	private String custId;
	private String validCode;
	private Timestamp validTime;
	private Timestamp regTime;
}