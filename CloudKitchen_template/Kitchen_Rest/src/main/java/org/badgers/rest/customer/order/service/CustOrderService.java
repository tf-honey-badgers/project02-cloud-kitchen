package org.badgers.rest.customer.order.service;

import org.badgers.rest.model.OrderInfoVO;

public interface CustOrderService {
	
	public int excuteOrder() throws Exception;
	
	public OrderInfoVO getOrderInfo() throws Exception;

	
}
