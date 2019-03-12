package org.badgers.rest.customer.order.service;

import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderVO;

public interface CustOrderService {
	
	public int excuteOrder() throws Exception;
	
	public OrderInfoVO getOrderInfo() throws Exception;
	public OrderVO test(String orderId) throws Exception;
	
}
