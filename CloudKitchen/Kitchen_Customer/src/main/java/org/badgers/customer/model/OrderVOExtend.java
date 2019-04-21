package org.badgers.customer.model;



import lombok.Data;

@Data
public class OrderVOExtend {
	private String id; // 생성
	private String custId; // 세션
	private String phone; // 세션 or 입력
	private String address; //세션 or 입력
	private String msg; // 입력
	private String kitchenName; // hidden----------
	private int payAmt; // input-------------------
	private String status; //자동
	private OrderPaymentVO orderPayment;//---------
	private OrderDetailVOExtend[] orderDetails;//--
	
//	public void mergeOrderVO(OrderVOExtend vo) {
//		this.custId = vo.getCustId();
//		this.phone=vo.getPhone();
//		this.address=vo.getAddress();
//	}
	
	
}
