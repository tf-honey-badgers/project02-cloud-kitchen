package org.badgers.rest.customer.member.service;

import java.util.List;

import javax.inject.Inject;

import org.badgers.rest.customer.member.persistence.CustomerMapper;
import org.badgers.rest.model.CartVOExtend;
import org.badgers.rest.model.CustomerVO;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Inject
	private CustomerMapper mapper;

	// 등록
	@Override
	public boolean register(CustomerVO vo) {
		System.out.println("등록");
		try {
			mapper.register(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	// 로그인 by Yuriel on 2019.03.13(WED)
	public String login(String id, String pw) {
		System.out.println("로그인 ========================================");
		
		String returnVal = "";
		CustomerVO queryResult = null;
		
		try {
			queryResult = mapper.login(id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(queryResult == null) {
			returnVal = "NO_ACCT"; // "계정 없음" 메시지
		} else {
			if(pw.equals(queryResult.getPw())) {
				returnVal = queryResult.getId(); // 아이디를 반환, 메시지가 아닌 아이디를 반환했다는 것 자체가 성공적인 로그인 인증을 의미
			} else {
				returnVal = "BAD_PWD"; // "비밀번호 틀림" 메시지
			}
		}
		
		return returnVal;
	}

// 
	public CustomerVO selectById(String id) {
		System.out.println("나와라=============");
		CustomerVO vo = mapper.selectById(id);

		return vo;
	}

	// 수정
	@Override
	public int modify(CustomerVO vo) throws Exception {

		return mapper.modify(vo); // cart 테이블에 수정된 행 개수 반환

	}

	// 삭제
	@Override
	public int delete(CustomerVO vo) throws Exception {

		return mapper.delete(vo);

	}
	
	
	//비번 변경 
	@Override
	public int changePwd(String id, String pw) throws Exception {
		
		return mapper.changePwd(id, pw);
	}

	//멤버리스트 
	@Override
	public List<CustomerVO> readMember(String id) throws Exception {
		return mapper.readMember(id);	
	}
}
