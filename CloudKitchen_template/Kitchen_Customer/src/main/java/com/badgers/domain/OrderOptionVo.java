package com.badgers.domain;

import lombok.Data;

@Data
public class OrderOptionVo {
	private String id;
	private String name;
	private int optPrice;
	private String optCode;
	private String detailNo;
}
