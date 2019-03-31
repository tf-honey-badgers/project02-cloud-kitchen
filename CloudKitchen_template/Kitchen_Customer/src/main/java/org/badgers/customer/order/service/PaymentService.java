package org.badgers.customer.order.service;

import org.badgers.customer.model.OrderVOExtend;
import org.springframework.http.HttpEntity;
import org.springframework.util.MultiValueMap;

public interface PaymentService {
	
	public HttpEntity<MultiValueMap<String, String>> kakaopay(OrderVOExtend vo);
	
   
        
    

}
