package org.badgers.rest.customer.member.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.badgers.rest.customer.member.service.CustomerService;
import org.badgers.rest.customer.order.service.ToOrderInfoForViewService;
import org.badgers.rest.model.CustomerVO;
import org.badgers.rest.model.OrderInfoVO;
import org.badgers.rest.model.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	@Autowired
	public ToOrderInfoForViewService toOrderInfoForViewService;

	//회원가입                                                                                                                          
	@PostMapping(value= "/register")
	public ResponseEntity<Integer> register(@RequestBody CustomerVO vo) throws Exception {
		ResponseEntity<Integer> entity = null;
		
		
		if(service.checkKakaoUser(vo.getId()) != null) {
			// 되어있으면 로그인 처리
			CustomerVO returnVal = service.login(vo.getId(), vo.getPw());	
				
		}
		
		else {
			String inputPass  = vo.getPw();
			String pass =passEncoder.encode(inputPass);
			vo.setPw(pass);
			
			int returnVal = service.register(vo);
			
		
			if(returnVal == 0) { entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST); }
			else { entity = new ResponseEntity<Integer>(returnVal, HttpStatus.OK); }
		
		}
		
		
		 
		 return entity;
	}

	// 로그인
	@SuppressWarnings("rawtypes")
	@PostMapping(value="/login" , produces = "application/json; charset=UTF-8")
	public ResponseEntity login(@RequestBody CustomerVO cvo) throws Exception {
		CustomerVO returnVal = service.login(cvo.getId(), cvo.getPw());		
		
		
		boolean passMatch = passEncoder.matches(cvo.getPw(), returnVal.getPw());
		
		log.info("**************************************************" + cvo.getPw() + "**************************************************");
		log.info("**************************************************" + returnVal.getPw() + "**************************************************");
		
		return (returnVal!=null && passMatch)?new ResponseEntity<>(returnVal, HttpStatus.OK): new ResponseEntity<>(returnVal,HttpStatus.NOT_FOUND);	
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
	@PutMapping("/{id}/changepwd")
	public int changePwd(@PathVariable("id") String id,@RequestBody CustomerVO input) {
		int returnVal = 0;

		try {
			String inputPass = input.getPw();
			String pass = passEncoder.encode(inputPass);
			input.setPw(pass);
			returnVal = service.changePwd(input.getId(), input.getPw());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnVal;
	}

	//삭제 -> 멤버 상태 수정 (status 변환)
	@PutMapping("/{id}/delete")
	public int delete(@PathVariable("id") String id,@RequestBody CustomerVO vo) {
		int returnValue = 0;

		try {
			returnValue = service.delete(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnValue;
	}

	
	//주문 상세 내역  보기 
	@GetMapping(value = "/{id}/mypage/orderinfo", produces="application/json; charset=utf-8")
	public ResponseEntity<?>  getOrderInfo(@PathVariable("id")String id) throws Exception {
		LinkedList<OrderInfoVO> list = (LinkedList<OrderInfoVO>) service.getOrderInfo(id);
		String jsonOrderInfoForView = toOrderInfoForViewService.toOrderInfoForView(list);
		return new ResponseEntity(jsonOrderInfoForView, HttpStatus.OK);
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
		
			//이메일 인증 
	
	@PostMapping(value = "/emailConfirm" ,produces= { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<Integer> emailConfirm(@RequestBody Map<String,String> map) throws Exception { // 이메일인증
				
		   ResponseEntity<Integer> entity = null;

		   log.info("이메일 인증 ================================== ");
			
				
		   int returnVal = service.userAuth(map.get("email"),map.get("key"));
				 
				
		   System.out.println("Rest");
		   System.out.println(returnVal);
		   if(returnVal == 0) { entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST); }
		   else { entity = new ResponseEntity<Integer>(Integer.valueOf(returnVal), HttpStatus.OK); }

		   return entity;
				
			}
	
		//주문 내역  보기 
		@GetMapping(value = "/{cust_id}/mypage/order", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
		public ResponseEntity<List<OrderVO>>  getOrder(@PathVariable("cust_id")String custId) throws Exception {
			List<OrderVO> list = service.getOrder(custId);

			return new ResponseEntity<List<OrderVO>>(list, HttpStatus.OK);
		}
}