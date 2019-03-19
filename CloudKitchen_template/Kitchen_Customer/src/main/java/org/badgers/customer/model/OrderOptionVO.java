package org.badgers.customer.model;

import lombok.Data;

@Data
public class OrderOptionVO {
	private String optId;
	private String optName;
	private int optPrice;
	private String orderDetailId;
}
