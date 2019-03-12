package org.badgers.rest.model;

import lombok.Data;

@Data
public class MenuCatVoExtend {
	private String mcNo;
	private String mcName;
	private String mcBizId;
	private int mcIdx;
	private MenuVoExtend mcMenuvo;
}
