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
		String pwd = "";
		
		CustomerVo vo = mapper.selectById(id);
		
		if(vo != null) pwd = vo.getPw();
		
		return pwd.equals(pw); 
	}

	
	public CustomerVo selectById(String id) {
		CustomerVo vo = mapper.selectById(id);
		
		
		try{
			vo.setId(vo.getId());
			vo.setPw(vo.getPw());
			vo.setName(name);
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	//public Member selectById(String id) {
		Member member = mapper.selectById(id);
		
		try {
			member.setId(aes.decrypt(member.getId()));
			member.setPassword(aes.decrypt(member.getPassword()));
			member.setName(aes.decrypt(member.getName()));
		} catch (UnsupportedEncodingException | GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}
	
	
	
	
	
	
	
	// 수정
	@Override
	public int modify(CustomerVo vo) throws Exception {

		int rowCnt = 0;
		
		try {
			CustomerVo.setId(member.getId()));
			member.setPassword(aes.encrypt(member.getPassword()));
			member.setName(aes.encrypt(member.getName()));
			rowCnt = mapper.update(member);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rowCnt == 1;

	}

	// 삭제
	@Override
	public int delete(CustomerVo vo) throws Exception {

		return mapper.delete(vo);

	}

}
