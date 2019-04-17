package org.badgers.business.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BizMemberVO {
	private String bizId;
	private String pw;
	private String name;
	private String regNo;
	private Timestamp joinDate;
	private String account;
}
