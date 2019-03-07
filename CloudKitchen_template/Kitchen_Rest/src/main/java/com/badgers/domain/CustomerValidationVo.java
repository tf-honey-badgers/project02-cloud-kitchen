package com.badgers.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CustomerValidationVo {
	private int no;
	private String custId;
	private String validCode;
	private Timestamp validTime;
	private Timestamp regTime;
}
