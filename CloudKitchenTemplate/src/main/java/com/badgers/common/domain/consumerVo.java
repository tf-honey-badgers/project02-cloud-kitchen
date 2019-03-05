package com.badgers.common.domain;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class consumerVo {
	private String id;
	private String pw;
	private String name;
	private Date birth_date;
	private String phone;
	private String email;
	private String gender;
	private String dropout;
	private Timestamp reg_date;
}