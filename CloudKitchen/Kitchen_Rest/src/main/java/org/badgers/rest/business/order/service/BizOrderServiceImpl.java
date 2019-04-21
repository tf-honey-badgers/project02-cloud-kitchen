package org.badgers.rest.business.order.service;


import org.badgers.rest.business.order.persistence.BizOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BizOrderServiceImpl implements BizOrderService {

	@Autowired
	BizOrderMapper mapper;
	
	@Override
	public int updateOrderStatus(String status, String bizId, String orderId) {
		
		mapper.updateOrderStatus(status, bizId, orderId);
		
		return 0;
	}

}
