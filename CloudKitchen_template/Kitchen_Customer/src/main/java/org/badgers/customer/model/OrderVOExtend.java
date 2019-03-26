package org.badgers.customer.model;



import lombok.Data;

@Data
public class OrderVOExtend {
	private String id;
	private String custId;
	private String phone;
	private String address;
	private String msg;
	private String kitchenName;
	private int payAmt;
	private String status;
	private OrderPaymentVO orderPayment;
	private OrderDetailVOExtend[] orderDetails;
	
	public void mergeOrderVO(OrderVOExtend vo) {
		this.custId = vo.getCustId();
		this.phone=vo.getPhone();
		this.address=vo.getAddress();
	}
	
	
}
