package org.badgers.customer.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CustomerValidationVO {
	private int no;
	private String custId;
	private String validCode;
	private Timestamp validTime;
	private Timestamp regTime;
}
