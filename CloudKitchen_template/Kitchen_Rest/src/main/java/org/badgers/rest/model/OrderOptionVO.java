package org.badgers.rest.model;

import lombok.Data;

@Data
public class OrderOptionVO {
	private String optName;
	private int optPrice;
	private String optId;
	private String orderDetailId;
}
