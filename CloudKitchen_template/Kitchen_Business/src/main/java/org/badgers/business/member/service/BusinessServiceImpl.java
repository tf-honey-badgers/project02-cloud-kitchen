package org.badgers.business.member.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BusinessServiceImpl {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		
		System.out.println("started.........");
		
		try {
			String url = "http://localhost:12007/business/biz_1/mypage";
			ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
		
			System.out.println("here I am");
			
			List<?> bizMember = responseEntity.getBody();

			for(int i = 0; i < bizMember.size(); i++) {
				System.out.println(bizMember.get(i));
			}

		}catch(Exception e){
			e.getStackTrace();
		}
	}
	
//	// 로그인
//	@GetMapping(value = "/{biz_id}")
//	public ResponseEntity<String> login(BizMemberVOExtend biz) throws Exception {}
//	
//	// 개인정보 수정
//	@PutMapping("/{biz_id}/mypage/modify")
//	public int modify(@PathVariable("biz_id")String bizId ,@RequestBody BizMemberVOExtend mvo) {}
}
