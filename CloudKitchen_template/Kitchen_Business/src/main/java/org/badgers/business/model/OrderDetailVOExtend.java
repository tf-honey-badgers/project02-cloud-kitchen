package org.badgers.business.model;


import lombok.Data;

@Data
public class OrderDetailVOExtend extends OrderDetailVO  {
	private String id;
	private String menuId;
	private String menuName;
	private int menuPrice;
	private int addOptionPrice;
	private int quantity;
	private int totalAmt;
	private String bizId;
	private String bizName;
	private String orderId;
	private OrderOptionVO[] orderOptions;

}
