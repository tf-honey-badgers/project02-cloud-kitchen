package org.badgers.rest.model;

import lombok.Data;

@Data
public class MenuCatVOExtend {
	private String mcNo;
	private String mcName;
	private String mcBizId;
	private int mcIdx;
	private MenuVOExtend mcMenuvo;
}
