package org.badgers.business.model;

import java.util.List;

import lombok.Data;

@Data
public class MenuOptionClVOExtend {
	private int mocNo;
	private String mocName;
	private String mocMenuOptType;
	private int mocMenuCode;
	private List<MenuOptionVOExtend> menuOptEx;
}
