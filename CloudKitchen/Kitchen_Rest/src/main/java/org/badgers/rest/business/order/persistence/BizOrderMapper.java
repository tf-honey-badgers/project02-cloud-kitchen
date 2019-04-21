package org.badgers.rest.business.order.persistence;

public interface BizOrderMapper {
	//개별 OrderDetail의 주문상태(status) Update
	public int updateOrderStatus(String bizId, String orderId, String status);
	public String getToken(String orderId);
	
}
