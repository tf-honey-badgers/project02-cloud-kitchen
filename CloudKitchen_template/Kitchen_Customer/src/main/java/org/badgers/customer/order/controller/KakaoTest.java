package org.badgers.customer.order.controller;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class KakaoTest {
	public static void main(String[] args) {
		paymentReady();
	}

    @SuppressWarnings("rawtypes")
	private static void paymentReady() {
        RestTemplate restTemplate = new RestTemplate();
    
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
	    params.add("cid", "TC0ONETIME");
	    params.add("partner_order_id", "1001");
	    params.add("partner_user_id", "test@koitt.com");
	    params.add("item_name", "갤럭시S9");
	    params.add("quantity", "1");
	    params.add("total_amount", "1155");
	    params.add("tax_free_amount", "0");
	    params.add("approval_url", "http://localhost:3001/customer/main");
	    params.add("cancel_url", "http://localhost:3001/customer/main");
	    params.add("fail_url", "http://localhost:3001/customer/main");
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Authorization", "KakaoAK " + "e0d26cb3e1a4b577fce26f8828fc6a49");
	    headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
	    headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
            
	    
	    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<Map> response = restTemplate.exchange("https://kapi.kakao.com/v1/payment/ready", HttpMethod.POST, request, Map.class);
        Map readyResp = response.getBody();
        System.out.println(readyResp);
    }
	
	
	
}
