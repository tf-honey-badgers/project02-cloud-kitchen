package org.badgers.business.member.service;

import java.util.List;

import org.badgers.business.model.BizMemberVO;
import org.badgers.business.model.BizMemberVOExtend;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BusinessServiceImpl implements BusinessService {
	
	// 회원 정보
	public BizMemberVOExtend readBizMember(String bizId) throws Exception {
		System.out.println("Kitchen_Business 사업자 개인정보 읽기...............................");
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			String url = "http://localhost:12007/business/" + bizId + "/mypage";
			
			ResponseEntity<BizMemberVOExtend> responseEntity =
					restTemplate.getForEntity(url, org.badgers.business.model.BizMemberVOExtend.class);
			
			System.out.println(responseEntity.getBody());

		}catch(Exception e){
			e.getStackTrace();
		}
		
		return null;
	}

	// 정보수정
	public int updateBizMember(BizMemberVOExtend mvo) throws Exception {
		return 0;
	}

	// 로그인
	public int login(String bizId, String pw) throws Exception{
		return 0;
	}
}
