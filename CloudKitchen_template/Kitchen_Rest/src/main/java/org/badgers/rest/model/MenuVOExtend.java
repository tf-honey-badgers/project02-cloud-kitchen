package org.badgers.rest.model;

import java.util.List;

import lombok.Data;

@Data
public class MenuVOExtend {
	private String mCode;
	private String mName;
	private int mBasicPrice;
	private String mPhoto;
	private String menuCatCode;
	private int mIdx;
	private List<MenuOptionClVOExtend> menuOptCl;
}
