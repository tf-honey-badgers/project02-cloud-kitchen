package org.badgers.rest.model;

import java.util.List;

import lombok.Data;

@Data
public class MenuOptionClVOExtend {
	private String mocNo;
	private String mocName;
	private String mocMenuOptType;
	private String mocMenuCode;
	private List<MenuOptionVOExtend> menuOptEx;
}
