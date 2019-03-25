package org.badgers.rest.customer.member.controller;

import java.util.List;

import org.badgers.rest.customer.member.service.CustomerService;
import org.badgers.rest.model.CustomerVO;
import org.badgers.rest.model.FavoriteVO;
import org.badgers.rest.model.OrderInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/customer")
@Log4j
public class CustomerController {

	@Setter(onMethod_ = { @Autowired })
	private CustomerService service;

	//회원가입                                                                                                                          
//	@PostMapping(value = "/register", consumes = "application/json", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
//	public ResponseEntity<String> register(@RequestBody CustomerVO vo) throws Exception {
//		ResponseEntity<String> entity = null;
//		
//		String returnVal = service.register(vo);
//		 if(returnVal == null) { entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST); }
//		 else { entity = new ResponseEntity<String>(returnVal, HttpStatus.OK); }
//		 
//		 return entity;
//	}
//	
	@PostMapping(value= "/register")
	public ResponseEntity<Integer> register(@RequestBody CustomerVO vo) throws Exception {
		ResponseEntity<Integer> entity = null;
		
		int returnVal = service.register(vo);
		 
		if(returnVal == 0) { entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST); }
		 else { entity = new ResponseEntity<Integer>(returnVal, HttpStatus.OK); }
		 
		 return entity;
	}
	
	
	// 로그인
	@PostMapping("/")
	public ResponseEntity<String> login(@RequestBody CustomerVO cvo) throws Exception {
		 String returnVal = service.login(cvo.getId(), cvo.getPw());

		 ResponseEntity<String> entity = new ResponseEntity<String>(returnVal, HttpStatus.OK);
		 
		 return entity;	
	}
		  
		
	
	//개인정보 끌어오기 
	@GetMapping(value = "/{id}/mypage", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<CustomerVO>  selectById(@PathVariable("id") String id) throws Exception {
		CustomerVO customer = service.selectById(id);
			

		return new ResponseEntity<CustomerVO>(customer, HttpStatus.OK);
	}
	


	
	// 개인정보 수정
	@PutMapping("/{id}/mypage/modify")
	public int modify(@PathVariable("id")String id, @RequestBody CustomerVO vo) {

		int returnVal = 0;

		try {
			returnVal 	= service.modify(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnVal;
	}

	// 비번만  변화
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
	
	//주문 내역  보기 
	@CrossOrigin("http://localhost:12004") //크로스 도메인 처리 
	@GetMapping(value = "/{cust_id}/mypage/orderinfo", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<List<OrderInfoVO>>  getOrderInfo(@PathVariable("cust_id")String custId) {
		List<OrderInfoVO> list = service.getOrderInfo(custId);
			

		return new ResponseEntity<List<OrderInfoVO>>(list, HttpStatus.OK);
	}
	
	
	
	//찜  내역  보기 
	@CrossOrigin("http://localhost:12004") //크로스 도메인 처리 
	@GetMapping(value = "/{cust_id}/mypage/favorite", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<List<FavoriteVO>>  favorite(@PathVariable("cust_id")String custId) {
			List<FavoriteVO> favorite = service.favorite(custId);
				

			return new ResponseEntity<List<FavoriteVO>>(favorite, HttpStatus.OK);
		}
	
	
	// ID 찾기 & 본인인증하기
		@PostMapping("/verify")
		public ResponseEntity<String> verify(@RequestBody CustomerVO vo) throws Exception {
			 ResponseEntity<String> entity = null;
			 
			 log.info("Kitchen_Rest 사용자 ID 찾기...............................");

			 String returnVal = service.verify(vo);
			 if(returnVal == null) { entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST); }
			 else { entity = new ResponseEntity<String>(returnVal, HttpStatus.OK); }
			 
			 return entity;
		}
	

}