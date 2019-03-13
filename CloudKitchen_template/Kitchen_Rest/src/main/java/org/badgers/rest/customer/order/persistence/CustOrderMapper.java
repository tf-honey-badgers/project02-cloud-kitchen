package org.badgers.rest.customer.order.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderVO;

public interface CustOrderMapper {
	
	public int insert1(String val);
	public int insert2(String val);
	
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
	public List<OrderInfoVO> getOrderInfo();
	
	public OrderVO test(@Param("orderId") String orderId);

	public List<OrderVO> getOrder(); 
	
}
