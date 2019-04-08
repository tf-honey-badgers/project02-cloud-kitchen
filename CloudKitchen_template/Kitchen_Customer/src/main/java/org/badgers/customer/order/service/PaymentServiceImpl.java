package org.badgers.customer.order.service;

import org.badgers.customer.model.OrderVOExtend;
import org.badgers.customer.util.RestDomain;
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
		 System.out.println(vo.getOrderDetails()[0].getMenuName()+
		    		(vo.getOrderDetails().length==1?"":(" 외 "+(vo.getOrderDetails().length-1)+"개 ")));
		    params.add("cid", "TC0ONETIME");
		    params.add("partner_order_id", vo.getId());
		    params.add("partner_user_id", vo.getCustId());
		    params.add("item_name", vo.getOrderDetails()[0].getMenuName()+
		    		(vo.getOrderDetails().length==1?"":(" 외 "+(vo.getOrderDetails().length-1)+"개 ")));
		    params.add("quantity", ""+vo.getOrderDetails().length);
		    params.add("total_amount", ""+vo.getPayAmt());
		    params.add("tax_free_amount", "0");
		    params.add("approval_url", RestDomain.localCustomerDomaim+"/order/payment/kakaoPay/success");
		    params.add("cancel_url", RestDomain.localCustomerDomaim+"/order/payment//kakaoPay/cancel");
		    params.add("fail_url", RestDomain.localCustomerDomaim+"/order/payment/kakaoPay/fail");
		    
		    HttpHeaders headers = new HttpHeaders();
		    headers.add("Authorization", "KakaoAK " + "e0d26cb3e1a4b577fce26f8828fc6a49");
		    headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		    headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

		    return new HttpEntity<MultiValueMap<String, String>>(params, headers);
		
	}

}
