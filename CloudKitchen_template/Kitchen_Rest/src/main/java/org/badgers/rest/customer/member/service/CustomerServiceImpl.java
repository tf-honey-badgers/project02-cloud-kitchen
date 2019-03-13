package org.badgers.rest.customer.member.service;

import javax.inject.Inject;

import org.badgers.rest.customer.member.persistence.CustomerMapper;
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

	// 로긴
	public boolean login(String id, String pw) {
		System.out.println("로긴");
		String pwd = "";
		CustomerVO vo = mapper.selectById(id);

		if (vo != null) pwd = vo.getPw();

		return pwd.equals(pw);

	}

// 
	public CustomerVO selectById(String id) {
		System.out.println("나와라");
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
}
