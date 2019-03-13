package org.badgers.rest.model;

import java.util.List;

import lombok.Data;

@Data
public class MenuCatVOExtend {
	private String mcNo;
	private String mcName;
	private String mcBizId;
	private int mcIdx;
	private List<MenuVOExtend> mcMenuvo;
}
