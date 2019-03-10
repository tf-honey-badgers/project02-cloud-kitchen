package org.badgers.rest.model;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class CustomerVo {
	private String id;
	private String pw;
	private String name;
	private Date birthDate;
	private String phone;
	private String email;
	private String gender;
	private String dropout;
	private Timestamp regDate;
}