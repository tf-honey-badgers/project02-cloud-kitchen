package org.badgers.rest.model;

import lombok.Data;

@Data
public class MenuOptionClVoExtend {
	private String mocNo;
	private String mocName;
	private String mocMenuOptType;
	private String mocMenuCode;
	private int mocIdx;
	private MenuOptionVoExtend menuOptEx;
}
