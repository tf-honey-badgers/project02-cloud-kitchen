package org.badgers.customer.member.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.badgers.customer.model.CustomerVO;
import org.badgers.customer.model.FavoriteVO;
import org.badgers.customer.model.OrderInfoVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j
public class CustomerController {
	
	@Inject
	RestTemplate restTemplate;
	
	// 조회
	@GetMapping("/{id}/change")
	public ModelAndView readCustomer(ModelAndView mav, @PathVariable("id") String id) {
		log.info("사용자 개인정보 읽기...............................");
		
		CustomerVO returnVal = null;
		String url = "http://localhost/rest/customer/" + id + "/mypage";
		
		try {
			ResponseEntity<CustomerVO> responseEntity = 
					restTemplate.getForEntity(url, org.badgers.customer.model.CustomerVO.class);

			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				returnVal = responseEntity.getBody();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		System.out.println(returnVal);		
		
		if(returnVal != null) { log.info("readCustomer DONE!!!!!"); }
		else {
			log.info("Failed to readCustomer. REST server may be offline.");
			mav.addObject("message", "Failed to read customer member data. REST server may be offline.");
		}

		mav.addObject("customer", returnVal);
		mav.setViewName("modify");
		
		return mav;
	}
	
	
	// 로그인
	@PostMapping(value = "/", produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String login(@RequestBody CustomerVO vo) {
		log.info("Kitchen_customer 사용자 로그인...............................");
		
		String msg = "";
		String url = "http://localhost/rest/customer/";
		
		try {
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, vo, String.class);
			msg = responseEntity.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 처리는 인터셉터에서 하기
		if(msg.equals("BAD_PW")) {
			msg = "비밀번호가 틀렸습니다.";
		} else if(msg.equals("NO_ID")) {
			msg = "존재하지 않는 아이디입니다.";
		} else if(msg.equals("SERVER_ERROR") || msg.equals("")) {
			msg = "서버에 에러가 발생했습니다. 조금 있다가 다시 시도해주세요.";
		} else {
			// 로그인을 유지하기 위한 쿠키 생성
			msg = "성공적으로 로그인했습니다.";
		}

		log.info(msg);
		
		return msg;
	}
	
<<<<<<< HEAD
	//회원정보 수정
=======
	
	//회원정보 수정 
>>>>>>> c3e70b060d0238980bad0116d5a0bb99d604a69c
	@PostMapping("/{id}/modify")
	@ResponseBody
	public void updateCustomer(@RequestBody CustomerVO cvo) {
		log.info("Kitchen_Business 사용자 개인정보 수정...............................");
		
		try {
			String url = "http://localhost/rest/customer/" + cvo.getId() + "/mypage/modify";
			restTemplate.put(url, cvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("회원 정보 수정 완료 ");

	}
	
	// 마이 페이지 
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage() {
		
		return "mypage";
	}	
	


	// 회원 가입 
	@PostMapping("/register")
	@ResponseBody
	public String register(@RequestBody CustomerVO customer) {
		String msg = "";
		String url = "http://localhost/rest/customer/register";
		
		try {
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, customer, String.class);
			msg = responseEntity.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return msg;
	}
	
	
	// 주문 내역 보기 
	@GetMapping(value = "/{custId}/mypage/orderinfo")
	public ModelAndView readOrderinfo(ModelAndView mav, @PathVariable("custId") String custId) {
		log.info("사용자 주문 내역 보기================================");
		
		List<OrderInfoVO> list = null;
		String url = "http://localhost/rest/customer/" + custId + "/mypage/orderinfo";
		try {
			ResponseEntity<OrderInfoVO> responseEntity =
					restTemplate.getForEntity(url,org.badgers.customer.model.OrderInfoVO.class);
			if(responseEntity.getStatusCode()==HttpStatus.OK) {
				list = (List<OrderInfoVO>) responseEntity.getBody();
			}
		
		}catch(Exception e) {
			e.getStackTrace();
		}
		System.out.println(list);
		
		mav.addObject("list",list);
		mav.setViewName("orderinfo");
		
		
		return mav;
<<<<<<< HEAD
			
	}
	
	// 회원가입 
	@PostMapping("/new")
	public ModelAndView register(ModelAndView mav, @RequestBody CustomerVO vo) {
		System.out.println(vo);
		
		try {
			service.register(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("회원 가입 성공 ");

		return mav;
=======
				    
	}
	
	

	
	// 찜 내역 보기 
	@GetMapping(value = "/{custId}/mypage")
	public ModelAndView readFavorite (ModelAndView mav, @PathVariable("custId") String custId) {
		log.info("사용자 찜 내역 보기================================");
		List<FavoriteVO> favorite = null;
		String url = "http://localhost/rest/favorite/" + custId + "/mypage";
		try {
			ResponseEntity<FavoriteVO> responseEntity =
					restTemplate.getForEntity(url,org.badgers.customer.model.FavoriteVO.class);
			if(responseEntity.getStatusCode()==HttpStatus.OK) {
				favorite = (List<FavoriteVO>) responseEntity.getBody();
			}
		
		}catch(Exception e) {
			e.getStackTrace();
		}
		System.out.println(favorite);
		
		mav.addObject("list",favorite); //뷰에 전달할 데이터 지정 
		mav.setViewName("favorite"); //뷰 이름 지정 
		
		
		return mav;
}
	
	//ID 찾기 
	@PostMapping("/verify")
	@ResponseBody
	public String verify(@RequestBody CustomerVO vo) {
		log.info("Kitchen_Business 사용자 ID 찾기...............................");

		String res = "";
		String url = "http://localhost/rest/customer/verify";
		
		try {			
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, vo, String.class);
			res = responseEntity.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("retrieved customer id");
		return res;
>>>>>>> c3e70b060d0238980bad0116d5a0bb99d604a69c
	}
	

	
	@GetMapping("/emailConfirm")

	public ModelAndView emailConfirm(ModelAndView mav,@RequestParam("email")String email, @RequestParam("key") String AuthCode) throws UnsupportedEncodingException {	
		Map<String, String> map = new HashMap<String, String>();
		map.put("email",email);
		map.put("key",AuthCode);	
		
	
		
	String url = "http://localhost/rest/customer/emailConfirm/";
	int a =0;
	
	try {
		ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url,map,Integer.class);
			log.info("들어간다");
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
		a	=  responseEntity.getBody();
		System.out.println("이것은="+a);		
		}
	} catch (Exception e) {
		e.getStackTrace();
	}
	
	
	
	if(a != 0) { log.info("이메일 인증 완료 ! "); }
	else {
		log.info("Failed to emailConfirm. REST server may be offline.");
		mav.addObject("message", "Failed to read customer member data. REST server may be offline.");
	}

	mav.addObject("customer", map);
	mav.setViewName("join_success");
	
	return mav;
	}

	
	
	
	
}
