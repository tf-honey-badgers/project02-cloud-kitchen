package org.badgers.rest.customer.order.service;

import java.util.List;

import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderVO;
import org.badgers.rest.model.ParamOrderVO;

public interface CustOrderService {
	
	
	public int excuteOrder(ParamOrderVO vo) throws Exception;
	
	public List<OrderInfoVO> getOrderInfo(String orderId) throws Exception;
	public OrderVO getOrderWithOrderId(String orderId) throws Exception;
	
	public List<OrderVO> getOrder(String orderId); 
	
}
