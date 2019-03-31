package org.badgers.customer.order.service;

import org.badgers.customer.model.OrderVOExtend;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Override
	public HttpEntity<MultiValueMap<String, String>> kakaopay(OrderVOExtend vo) {
		
		 MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		 System.out.println(vo.getOrderDetails()[1].getMenuName()+" 외 "+(vo.getOrderDetails().length-1)+"개 ");
		    params.add("cid", "TC0ONETIME");
		    params.add("partner_order_id", "tempID"/*vo.getId()*/);
		    params.add("partner_user_id", "userID"/*vo.getCustId()*/);
		    params.add("item_name", vo.getOrderDetails()[1].getMenuName()+" 외 "+(vo.getOrderDetails().length-1)+"개 ");
		    params.add("quantity", ""+vo.getOrderDetails().length);
		    params.add("total_amount", ""+vo.getPayAmt());
		    params.add("tax_free_amount", "0");
		    params.add("approval_url", "http://localhost:3001/customer/order/confirm");
		    params.add("cancel_url", "http://localhost:3001/customer/order/orderinfo");
		    params.add("fail_url", "http://localhost:3001/customer/order/orderinfo");
		    
		    HttpHeaders headers = new HttpHeaders();
		    headers.add("Authorization", "KakaoAK " + "e0d26cb3e1a4b577fce26f8828fc6a49");
		    headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		    headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

		    return new HttpEntity<MultiValueMap<String, String>>(params, headers);
		
	}

}
