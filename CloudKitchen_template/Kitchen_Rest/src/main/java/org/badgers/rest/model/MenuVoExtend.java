package org.badgers.rest.model;

import lombok.Data;

@Data
public class MenuVoExtend {
	private String mCode;
	private String mName;
	private int mBasicPrice;
	private String mPhoto;
	private String menuCatCode;
	private int mIdx;
	private MenuOptionClVoExtend menuOptCl;
}
