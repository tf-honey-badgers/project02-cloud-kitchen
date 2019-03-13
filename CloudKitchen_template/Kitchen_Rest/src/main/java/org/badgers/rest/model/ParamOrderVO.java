package org.badgers.rest.model;

import lombok.Data;

@Data
public class ParamOrderVO extends OrderInfoVO{
	
	private int amount;
	private String method;
	private String payTime;
	private String bizId;
	private String menuId;

	public ParamOrderVO() {
		super();
	};
	
	public ParamOrderVO(
			String id, String phone, String address, String msg, int payAmt, String status,
			String kitchenName, String custId, String orderDetailId, int quantity, 
			int menuPrice, int addOptionPrice,
			int totalAmt, String bizName, String orderOptId, String orderOptName, 
			int optPrice, String optId,
			String requestMsg, int amount, String method, String bizId, String menuId) {
		super(id, phone, address, msg, payAmt, status, kitchenName, custId, orderDetailId, 
				quantity, menuPrice, addOptionPrice,
				totalAmt, bizName, orderOptId, orderOptName, optPrice, optId, requestMsg);
		this.amount = amount;
		this.method = method;
		this.bizId = bizId;
		this.menuId = menuId;
	}

	public OrderVO getOrderVO() {
		OrderVO vo = new OrderVO();
		vo.setId(super.getId());
		vo.setPhone(super.getPhone());
		vo.setAddress(super.getAddress());
		vo.setMsg(super.getMsg());
		vo.setPayAmt(super.getPayAmt());
		vo.setStatus(super.getStatus());
		vo.setKitchenName(super.getKitchenName());
		vo.setCustId(super.getCustId());
		return vo;
	}
	
	public OrderDetailVO getOrderDetailVO() {
		OrderDetailVO vo = new OrderDetailVO();
		vo.setId(super.getId());
		vo.setQuantity(super.getQuantity());
		vo.setMenuPrice(super.getMenuPrice());
		vo.setAddOptionPrice(super.getAddOptionPrice());
		vo.setTotalAmt(super.getTotalAmt());
		vo.setBizName(super.getBizName());
		vo.setBizId(this.bizId);
		vo.setMenuId(this.menuId);
		vo.setRequestMsg(super.getRequestMsg());;
		
		return vo;
	}
	
	
	public OrderOptionVO getOrderOptionVO() {
		OrderOptionVO vo = new OrderOptionVO();
		vo.setOptId(super.getId());
		vo.setOptName(super.getOrderOptName());
		vo.setOptPrice(super.getOptPrice());
		vo.setOptId(super.getOptId());
		vo.setOrderDetailId(super.getOrderDetailId());
		
		return vo;
	}
	
	public OrderPaymentVO getOrderPaymentVO() {
		OrderPaymentVO vo = new OrderPaymentVO();
		vo.setId(super.getId());
		vo.setAmount(this.amount);
		vo.setMethod(this.method);
		
		return vo;
	}


	

	
	
}
