package org.badgers.rest.customer.member.controller;

import java.util.List;

import org.badgers.rest.customer.member.service.CustomerService;
import org.badgers.rest.model.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/customers")
@Log4j
public class CustomerController {

	@Setter(onMethod_ = { @Autowired })
	private CustomerService service;

	//회원가입
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> register(@RequestBody CustomerVO vo) throws Exception {
		boolean result = service.register(vo);
		log.info("insert result : " + result);

		return result ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 로그인
	@GetMapping(value = "/{id}")
	public ResponseEntity<String> login(CustomerVO in) throws Exception {
		 ResponseEntity<String> entity = null;
		 if(entity ==null || ((CharSequence) entity).length()==0) {
			 log.info("없다 없다");
		 }
		 try {
		      entity = new ResponseEntity<>(service.login(in.getId(), in.getPw()), HttpStatus.OK);

		    } catch (Exception e) {
		      e.printStackTrace();
		      entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		    }

		    return entity;	
		  }
		
	
	//마페지
	@GetMapping(value = "/{id}/mypage", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<List<CustomerVO>>  selectById(@PathVariable("id") String id) {
		List<CustomerVO> list = service.selectById(id);
			

		return new ResponseEntity<List<CustomerVO>>(list, HttpStatus.OK);
	}
	


	
	// 수정
	@PutMapping("/modify/{id}")
	public int modify(@PathVariable("id")String id, @RequestBody CustomerVO vo) {

		int returnVal = 0;

		try {
			returnVal 	= service.modify(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnVal;
	}

	// 비번 변화
	@PutMapping("/changePwd")
	public int changePwd(@RequestBody CustomerVO input) {

		int returnVal = 0;

		try {
			returnVal = service.changePwd(input.getId(), input.getPw());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnVal;
	}

	//삭제 -> 멤버 상태 수정 (status 변환)
	@PutMapping("/delete/{id}")
	public int delete(@PathVariable("id") String id,@RequestBody CustomerVO vo) {

		int returnValue = 0;

		try {
			returnValue = service.delete(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnValue;
	}
	
	
	
	

}