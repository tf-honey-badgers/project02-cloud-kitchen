package org.badgers.business.model;

import lombok.Data;

@Data
public class OrderOptionVO {
	private String id;
	private String name;
	private int optPrice;
	private String optCode;
	private String detailNo;
}
