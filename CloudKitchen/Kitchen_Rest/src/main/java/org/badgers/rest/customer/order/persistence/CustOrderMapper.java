package org.badgers.rest.customer.order.persistence;

import java.util.LinkedList;

import org.badgers.rest.model.OrderDetailVOExtend;
import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderOptionVO;
import org.badgers.rest.model.OrderPaymentVO;
import org.badgers.rest.model.OrderVOExtend;

public interface CustOrderMapper {
	
	
	//insert 된 order 튜플을  select 해서 customer Controller로 보내줌
	public LinkedList<OrderInfoVO> getOrderInfo(String orderId);
	
	//===========================================================
	//order 기본 정보 입력
	public int initOrder(OrderVOExtend vo);
	//order_payment 기본 정보 입력
	public int addPayment(OrderPaymentVO vo);
	//order_detail 기본 정보 입력
	public int initOrderDetail(OrderDetailVOExtend vo);
	//order_menu_option 기본 정보 입력(ex: 옵션 2개 추가 - 옵션은 0~ n개 사이) 
	public int initOrderMenuOption(OrderOptionVO vo);
	
}
