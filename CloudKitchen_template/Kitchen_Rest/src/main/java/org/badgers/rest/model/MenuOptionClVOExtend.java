package org.badgers.rest.model;

import lombok.Data;

@Data
public class MenuOptionClVOExtend {
	private String mocNo;
	private String mocName;
	private String mocMenuOptType;
	private String mocMenuCode;
	private int mocIdx;
	private MenuOptionVOExtend menuOptEx;
}
