package com.badgers.common.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class joinValidationVo {
	private int no;
	private String cust_id;
	private String valid_code;
	private Timestamp valid_time;
	private Timestamp reg_time;
}
