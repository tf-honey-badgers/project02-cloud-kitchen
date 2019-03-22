package org.badgers.customer.model;

import java.util.List;

import lombok.Data;

@Data
public class MenuCatVOExtend {
	private int mcNo;
	private String mcName;
	private String mcBizId;
	private List<MenuVOExtend> mcMenuVo;
}
