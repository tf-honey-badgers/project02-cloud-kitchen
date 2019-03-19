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

	@Override
	public CustomerVO readCustomerMember(String id) throws Exception {
		log.info("Customer 이용자 개인정보 읽기...............................");
		RestTemplate restTemplate = new RestTemplate();
		CustomerVO returnVal = null;
		
		try {
			String url = "http://localhost:12007/customers/" + id + "/mypage";
			
			ResponseEntity<CustomerVO> responseEntity =
					restTemplate.getForEntity(url, org.badgers.customer.model.CustomerVO.class);
			
			if(responseEntity.getStatusCode() == HttpStatus.OK) {
				returnVal = responseEntity.getBody();
			}
		}catch(Exception e){
			e.getStackTrace();
		}
		
		return returnVal;
	}

}
