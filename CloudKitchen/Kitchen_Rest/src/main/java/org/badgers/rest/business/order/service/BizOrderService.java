package org.badgers.rest.business.order.service;

public interface BizOrderService {
	//개별 OrderDetail의 주문상태(status) Update
	public int updateOrderStatus(String status, String bizId, String orderId) throws Exception;
}
