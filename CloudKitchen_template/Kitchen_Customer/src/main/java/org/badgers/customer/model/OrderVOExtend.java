package org.badgers.customer.model;



import lombok.Data;

@Data
public class OrderVOExtend {
	private String id; //결제 완료시 생성
	private String custId; //세션
	private String phone; //세션
	private String address; //세션
	private String msg; // 세션
	private String kitchenName;
	private int payAmt;
	private String status; //db default로 자동입력
	private OrderPaymentVO orderPayment;
	private OrderDetailVOExtend[] orderDetails;
	
	
	public void mergeOrderVO(OrderVOExtend vo) {
		this.custId=vo.getCustId();
		this.phone=vo.getPhone();
		this.address=vo.getAddress();
		
	}
}
