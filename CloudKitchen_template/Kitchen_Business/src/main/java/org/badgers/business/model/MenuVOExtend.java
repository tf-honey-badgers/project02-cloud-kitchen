package org.badgers.business.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class MenuVOExtend {
	private int mCode;
	private String mName;
	private int mBasicPrice;
	private String mPhoto;
	private int menuCatCode;
	private List<MenuOptionClVOExtend> menuOptCl;
}
