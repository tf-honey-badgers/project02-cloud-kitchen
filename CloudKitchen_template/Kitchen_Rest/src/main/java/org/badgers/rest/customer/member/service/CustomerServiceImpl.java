package org.badgers.rest.customer.member.service;

import javax.inject.Inject;

import org.badgers.rest.customer.member.persistence.CustomerMapper;
import org.badgers.rest.model.CustomerVo;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Inject
	private CustomerMapper mapper;

	// 등록
	@Override
	public boolean register(CustomerVo vo) {
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
		CustomerVo vo = null;

		try {
			vo = mapper.selectById(id);
			vo.setId(vo.getId());
			vo.setPw(vo.getPw());
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (vo != null)
			pwd = vo.getPw();

		return pwd.equals(pw);

	}

// 
	public CustomerVo selectById(String id) {
		System.out.println("나와라");
		CustomerVo vo = mapper.selectById(id);

		try {
			vo.setId(vo.getId());
			vo.setPw(vo.getPw());
			vo.setName(vo.getName());
			vo.setBirthDate(vo.getBirthDate());
			vo.setPhone(vo.getPhone());
			vo.setEmail(vo.getEmail());
			vo.setGender(vo.getGender());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vo;
	}

	// 수정
	@Override
	public int modify(CustomerVo vo) throws Exception {

		return mapper.modify(vo); // cart 테이블에 수정된 행 개수 반환

	}

	// 삭제
	@Override
	public int delete(CustomerVo vo) throws Exception {

		return mapper.delete(vo);

	}
}
