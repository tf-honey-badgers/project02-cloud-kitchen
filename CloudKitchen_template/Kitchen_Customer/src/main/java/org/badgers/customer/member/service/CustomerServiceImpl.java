package org.badgers.customer.member.service;

import org.badgers.customer.model.CustomerVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class CustomerServiceImpl implements CustomerService {

	// 이용자 정보
	public CustomerVO readCustomer(String id) throws Exception {
		log.info("Customer 이용자 개인정보 읽기...............................");
		
		RestTemplate restTemplate = new RestTemplate();
		
		CustomerVO returnVal = null;

		try {
			String url = "http://localhost:12007/customer/" + id + "/mypage";

			ResponseEntity<CustomerVO> responseEntity = 
					restTemplate.getForEntity(url, org.badgers.customer.model.CustomerVO.class);

			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				returnVal = responseEntity.getBody();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

		return returnVal;
	}

	// 로그인
	public String login(CustomerVO customer) throws Exception {
		
		RestTemplate restTemplate = new RestTemplate();

		String res = "";
		
		try {
			String url = "http://localhost:12007/customer/";

			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, customer, String.class);
			res = responseEntity.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	//개인정보 수정  비번 , 이름 , 이메일 바꿀수 있음 
	public void updateCustomer(CustomerVO cvo) throws Exception {
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			String url = "http://localhost:12007/customer/" + cvo.getId() + "/mypage/modify";
						 
			restTemplate.put(url, cvo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public String register(CustomerVO vo) {
		RestTemplate restTemplate = new RestTemplate();
		
		System.out.println("회원가입");
		
		String sign = "";
		
		try {
			String url = "http://localhost:12007/customer/new";
			
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, vo, String.class);
			sign = responseEntity.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sign;
	}

}
