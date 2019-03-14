package org.badgers.rest.customer.order.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.badgers.rest.model.OrderDetailVO;
import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderOptionVO;
import org.badgers.rest.model.OrderPaymentVO;
import org.badgers.rest.model.OrderVO;

public interface CustOrderMapper {
	
	public int insert1(String val);
	public int insert2(String val);
	
	//order_payment 기본 정보 입력
	public int addPayment(OrderPaymentVO vo);
	
	//order 기본 정보 입력
	public int initOrder(OrderVO vo);
	
	//order_detail 기본 정보 입력
	public int initOrderDetail(OrderDetailVO vo);
	
	//order_menu_option 기본 정보 입력(ex: 옵션 2개 추가 - 옵션은 0~ n개 사이) 
	public int initOrderMenuOption(OrderOptionVO vo);
	
	//insert 된 order 튜플을  select 해서 customer Controller로 보내줌
	public List<OrderInfoVO> getOrderInfo(String orderId);
	
	public OrderVO test(@Param("orderId") String orderId);

	public List<OrderVO> getOrder(String orderId); 
	
	
}
