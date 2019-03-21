package org.badgers.rest.customer.order.service;

import java.util.LinkedList;
import java.util.List;

import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderVOExtend;

public interface CustOrderService {
	
	public LinkedList<OrderInfoVO> getOrderInfo(String orderId) throws Exception;
	public int excuteOrder(OrderVOExtend vo) throws Exception;
}

