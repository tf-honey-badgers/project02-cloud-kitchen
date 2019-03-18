package org.badgers.business.member.service;

import java.util.List;

import org.badgers.business.model.BizMemberVO;
import org.badgers.business.model.BizMemberVOExtend;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BusinessServiceImpl implements BusinessService{

	@Override
	public ResponseEntity<BizMemberVO> readBizMember(String bizId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> login(BizMemberVOExtend biz) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Integer> updateBizMember(String bizId, BizMemberVOExtend biz) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
//	// 로그인
//	@GetMapping(value = "/{biz_id}")
//	public ResponseEntity<String> login(BizMemberVOExtend biz) throws Exception {}
//	
//	// 개인정보 수정
//	@PutMapping("/{biz_id}/mypage/modify")
//	public int modify(@PathVariable("biz_id")String bizId ,@RequestBody BizMemberVOExtend mvo) {}
}
