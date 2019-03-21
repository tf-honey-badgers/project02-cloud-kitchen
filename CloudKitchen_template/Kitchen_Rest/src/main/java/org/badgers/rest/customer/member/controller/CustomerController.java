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
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> register(@RequestBody CustomerVO vo) throws Exception {
		boolean result = service.register(vo);
		log.info("insert result : " + result);

		return result ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 로그인
	@PostMapping(value = "/")
	public ResponseEntity<String> login(@RequestBody CustomerVO cvo) throws Exception {
			ResponseEntity<String> entity = null;
		 
		 System.out.println(cvo.getId());

		 try {
			 int returnVal = service.login(cvo.getId(), cvo.getPw());
			 if(returnVal == 1) { // 정상처리, 아이디를 다시 돌려보낸다 -> 프런트 도메인에서 로그인 처리할 것
				 entity = new ResponseEntity<String>(cvo.getId(), HttpStatus.OK);
			 } else if (returnVal == -1) { // 아이디는 맞지만 비번 틀림
				 entity = new ResponseEntity<String>("PW_BAD", HttpStatus.BAD_REQUEST);
			 } else if (returnVal == -2) { // 아이디가 존재하지 않는다
				 entity = new ResponseEntity<String>("NO_ID", HttpStatus.BAD_REQUEST);
			 }
			 log.info("연결 ==================== ");
		 } catch (Exception e) {
			 e.printStackTrace();
			 entity = new ResponseEntity<String>("SERVER_ERROR", HttpStatus.SERVICE_UNAVAILABLE);
			 log.info("에러 에러=========================== ");
		 }
		 
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
	@GetMapping(value = "/{cust_id}/mypage/orderinfo", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<List<OrderInfoVO>>  getOrderInfo(@PathVariable("cust_id")String custId) {
		List<OrderInfoVO> list = service.getOrderInfo(custId);
			

		return new ResponseEntity<List<OrderInfoVO>>(list, HttpStatus.OK);
	}
	
	
	
	//찜  내역  보기 
	@GetMapping(value = "/{cust_id}/mypage/favorite", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<List<FavoriteVO>>  favorite(@PathVariable("cust_id")String custId) {
			List<FavoriteVO> favorite = service.favorite(custId);
				

			return new ResponseEntity<List<FavoriteVO>>(favorite, HttpStatus.OK);
		}
	
	
	
	

}