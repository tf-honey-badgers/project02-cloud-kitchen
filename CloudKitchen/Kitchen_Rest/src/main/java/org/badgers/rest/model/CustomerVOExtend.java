package org.badgers.rest.model;

import java.util.List;

import lombok.Data;

@Data
public class CustomerVOExtend {
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
	private List<OrderInfoVO> oIo;
	
	
}
