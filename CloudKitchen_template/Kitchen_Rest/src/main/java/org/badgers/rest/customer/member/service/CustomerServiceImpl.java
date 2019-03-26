package org.badgers.rest.customer.member.service;

import java.util.List;

import javax.inject.Inject;

import org.badgers.rest.customer.member.persistence.CustomerMapper;
import org.badgers.rest.model.CustomerVO;
import org.badgers.rest.model.FavoriteVO;
import org.badgers.rest.model.OrderInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Inject
	private CustomerMapper mapper;
	
	@Autowired
	private JavaMailSender mailSender;

	// 등록
//	@Override
//	@Transactional
//	public int register(CustomerVO vo) throws Exception {
//		System.out.println("등록");
//		int returnVal = 0;
//		
//		try {
//			returnVal = mapper.register(vo);
//			String authkey = new TempKey().getKey(50, false);
//			
//			vo.setAuthkey(authkey);
//			mapper.updateAuthkey(vo);
//			
//			// mail 작성 관련 
//			MailUtils sendMail = new MailUtils(mailSender);
//
//			sendMail.setSubject("[Kloud Kitchen] 회원가입 이메일 인증");
//			sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")
//					.append("<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>")
//					.append("<a href='http://localhost:12007/rest/customer/joinConfirm?=")
//					.append("&email=")
//					.append(vo.getEmail())
//					.append("&authkey=")
//					.append(authkey)
//					.append("' target='_blenk'>이메일 인증 확인</a>")
//					.toString());
//			sendMail.setFrom("kloudkitchen5@gmail.com ", "클라우드 키친");
//			sendMail.setTo(vo.getEmail());
//			sendMail.send();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return returnVal;
//	}

	
	@Override
	public int register(CustomerVO vo) {
		System.out.println("등록");
		int returnVal = 0;
		
		try {
			returnVal = mapper.register(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnVal;
	}
	
	
	
	// 로그인 by Yuriel on 2019.03.13(WED)
	@Override
	public String login(String id, String pw) {
		System.out.println("로그인 ========================================");

		String returnVal = "";
		CustomerVO queryResult = null;

		try {
			queryResult = mapper.login(id);
			if(queryResult.getPw().equals(pw)) {
				returnVal = queryResult.getId(); // 입력한 비번 == DB 비번
			} else {
				returnVal = "BAD_PW"; // 입력한 비번 != DB 비번
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnVal = "NO_ID"; // DB에 입력한 ID 없음 표시
		}

		return returnVal;
	}
	

// 회원정보
	@Override
	public CustomerVO selectById(String id) throws Exception {
		System.out.println("나와라=============");
		CustomerVO customer = mapper.selectById(id);

		return customer;
	}

	// 수정
	@Override
	public int modify(CustomerVO vo) throws Exception {

		return mapper.modify(vo); // customer 테이블에 수정된 행 개수 반환

	}

	// 삭제
	@Override
	public int delete(CustomerVO vo) throws Exception {

		return mapper.delete(vo);

	}

	// 비번 변경
	@Override
	public int changePwd(String id, String pw) throws Exception {

		return mapper.changePwd(id, pw);
	}

	// 멤버리스트
	@Override
	public List<CustomerVO> readMember(String id) throws Exception {
		List<CustomerVO> results = null;
		results = mapper.readMember(id);
		return results;
	}
	
	
	//주문 정보 
	@Override
	public List<OrderInfoVO> getOrderInfo(String custId) {
		System.out.println("오더 정보 나와라=============");
		List<OrderInfoVO> list = mapper.getOrderInfo(custId);

		return list;
	}
	
	//찜정보
	@Override
	public List<FavoriteVO> favorite(String custId) {
		System.out.println("찜 정보  나와라=============");
		List<FavoriteVO> favorite = mapper.favorite(custId);

		return favorite;
	}
	
	// ID 찾기 & 본인인증하기
		public String verify(CustomerVO vo) throws Exception {
			String returnVal = "";
			
			try {
				returnVal = mapper.verify(vo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return returnVal;
		}
	
	
}
