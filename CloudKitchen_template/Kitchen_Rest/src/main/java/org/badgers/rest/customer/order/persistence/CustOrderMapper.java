package org.badgers.rest.customer.order.persistence;

import org.badgers.rest.model.OrderInfoVO;

public interface CustOrderMapper {
	
	//order_id 생성
	public int getOrderId();
	
	//order 기본 정보 입력
	public int initOrder();
	
	//order_detail 기본 정보 입력
	public int initOrderDetail();
	
	//order_menu_option 기본 정보 입력(ex: 옵션 2개 추가 - 옵션은 0~ n개 사이) 
	public int initOrderMenuOption();
	
	//order_detail 에 add_option_price 컬럼을 Update
	public int addOrderDetailOptionPrice();
	
	//order_detail 에 total_amt 컬럼을 Update
	public int addOrderDetailTotalAmount();
	
	//order 에 pay_amt 컬럼을 Update
	public int addOrderPayAmount();
	
	//insert 된 order 튜플을  select 해서 customer Controller로 보내줌
	public OrderInfoVO getOrderInfo();

	
}
