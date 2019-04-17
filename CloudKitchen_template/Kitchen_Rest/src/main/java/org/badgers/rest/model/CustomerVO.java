package org.badgers.rest.model;

import lombok.Data;

@Data
public class CustomerVO {
	private String id;
	private String pw;
	private String name;
	private String birthDate;
	private String phone;
	private String email;
	private String gender;
	private String status;
	private String regDate;
	private String idx;
	private String AuthCode;
	private String address;
	private String addressDetail;
	
}
