package org.badgers.rest.customer.order.service;

import java.util.List;

import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderVO;

public interface CustOrderService {
	
	public void insertAAA(String val);
	
	public int excuteOrder() throws Exception;
	
	public List<OrderInfoVO> getOrderInfo() throws Exception;
	public OrderVO test(String orderId) throws Exception;
	
	public List<OrderVO> getOrder(); 
	
}
