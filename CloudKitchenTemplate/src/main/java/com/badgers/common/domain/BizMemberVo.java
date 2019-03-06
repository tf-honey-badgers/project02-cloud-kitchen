package com.badgers.common.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BizMemberVo {
	// Table : biz_member
	private String bizId;
	private String pw;
	private String name;
	private String regNo;
	private Timestamp joinDate;
	private String account;
}