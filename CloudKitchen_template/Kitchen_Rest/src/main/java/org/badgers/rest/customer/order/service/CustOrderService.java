package org.badgers.rest.customer.order.service;

import java.util.List;

import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderVOExtend;

public interface CustOrderService {
	
	public List<OrderInfoVO> getOrderInfo(String orderId) throws Exception;
	public int excuteOrder(OrderVOExtend vo) throws Exception;
	public void testTx();
}
