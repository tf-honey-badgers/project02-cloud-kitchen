package org.badgers.business.member.service;

import javax.inject.Inject;

import org.badgers.business.model.BizMemberVOExtend;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BusinessServiceImpl implements BusinessService {
	
	@Inject
	RestTemplate restTemplate;
	
	// 회원 정보
	public BizMemberVOExtend readBizMember(String bizId) throws Exception {
		log.info("Kitchen_Business 사업자 개인정보 읽기...............................");
		
		BizMemberVOExtend returnVal = null;
		String url = "http://localhost:12007/business/" + bizId + "/mypage";
		
		ResponseEntity<BizMemberVOExtend> responseEntity = restTemplate.getForEntity(url, org.badgers.business.model.BizMemberVOExtend.class);
		
		if(responseEntity.getStatusCode() == HttpStatus.OK) {
			returnVal = responseEntity.getBody();
		}
		
		return returnVal;
	}

	// 정보수정 -> RestTemplate's Put 메서드가 반환값이 없다!
	public void updateBizMember(BizMemberVOExtend mvo) throws Exception {
		log.info("Kitchen_Business 사업자 개인정보 수정...............................");
				
		String url = "http://localhost:12007/business/" + mvo.getBizId() + "/mypage/modify";
		restTemplate.put(url, mvo);
	}

	// 로그인
	public String login(BizMemberVOExtend bizMember) throws Exception{
		log.info("Kitchen_Business 사업자 로그인...............................");
				
		String res = "";
		String url = "http://localhost:12007/business/";
		
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, bizMember, String.class);
		res = responseEntity.getBody();
		
		return res;
	}
	
	public String findBizId(BizMemberVOExtend bizMember) throws Exception {
		log.info("Kitchen_Business 사업자 ID 찾기...............................");
		
		String res = "";
		String url = "http://localhost:12007/business/findId";
		
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, bizMember, String.class);
		res = responseEntity.getBody();
		
		return res;
	}
}