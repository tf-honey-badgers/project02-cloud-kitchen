package org.badgers.customer.member.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.badgers.customer.model.CustomerVO;
import org.badgers.customer.model.FavoriteVO;
import org.badgers.customer.model.OrderInfoVO;
import org.badgers.customer.model.OrderVO;
import org.badgers.customer.util.RestDomain;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j
public class CustomerController {
	@Inject
	RestTemplate restTemplate;
	
	// 사용자 개인정보 조회
	@GetMapping("/{id}/change")
	public ModelAndView readCustomer(ModelAndView mav, @PathVariable("id") String id ,HttpSession session) {
		log.info("사용자 개인정보 읽기...............................");
		
		CustomerVO returnVal = null; 
		String url = RestDomain.restDomain+"/customer/" + id + "/mypage";
		// 사용자 정보 읽어오기
		ResponseEntity<CustomerVO> responseEntity = restTemplate.getForEntity(url, org.badgers.customer.model.CustomerVO.class);
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			returnVal = responseEntity.getBody();
		}
		
		if(returnVal != null) { log.info("readCustomer DONE!!!!!"); }
		else {
			log.info("Failed to readCustomer. REST server may be offline.");
			mav.addObject("message", "Failed to read customer member data. REST server may be offline.");
		}

		mav.addObject("customer", returnVal);
		log.info("returnVal");
		session.setAttribute("login", returnVal);
		mav.setViewName("modify");
		
		return mav;
	}	
	
	// 로그인
	@PostMapping(value = "/login", produces = "text/plain; charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody CustomerVO vo, ModelAndView mov) {
		
		log.info("Kitchen_customer 사용자 로그인...............................");
		HttpHeaders responseHeaders=null;
		int status = 0;
		
		String msg ="";
		
		String url = RestDomain.restDomain+"/customer/login";

		try {
		ResponseEntity<CustomerVO> responseEntity = restTemplate.postForEntity(url, vo, CustomerVO.class);
		CustomerVO member = responseEntity.getBody();
		status = responseEntity.getStatusCodeValue();
		responseHeaders = new HttpHeaders();
		
		if(status==200) {
			responseHeaders.set("id",member.getId() );
			responseHeaders.set("idx",member.getIdx() );
			responseHeaders.set("name",member.getName() );			
			responseHeaders.set("phone", member.getPhone());
			responseHeaders.set("address", member.getAddress());
			responseHeaders.set("addressDetail", member.getAddressDetail());
			msg="로그인 성공";
			System.out.println("프론트"+member.getIdx());
		}
		
		}catch (Exception e) {
			if(e.getMessage().contains("failed: Connection refused: connect")) {
				msg="로그인 실패";
				
			}
			
		}
		return new ResponseEntity<>(msg, responseHeaders,HttpStatus.OK);	
	}
	
	
	//로그아웃 
	@GetMapping("/logout")
	public String logout (Model model) {
		model.addAttribute("logout", "logout");
	
		return "redirect:/main";
	}
	
	//회원정보 수정 
	@PostMapping("/{id}/modify")
	@ResponseBody
	public void updateCustomer(@RequestBody CustomerVO cvo) {
		log.info("Kitchen_Business 사용자 개인정보 수정...............................");
		
		String url = RestDomain.restDomain+"/customer/" + cvo.getId() + "/mypage/modify";
		restTemplate.put(url, cvo);
				
		log.info("회원 정보 수정 완료 ");
	}
	
	//회원정보 삭제 
	@PostMapping("/{id}/delete")
	@ResponseBody
	public void deleteCustomer(@RequestBody CustomerVO cvo, HttpSession session) {
		log.info("Kitchen_Business 사용자 탈퇴...............................");
	
		String url = RestDomain.restDomain+"/customer/" + cvo.getId() + "/delete";
		restTemplate.put(url, cvo);
		
		session.invalidate();		
		log.info("회원탈퇴 완료");
	}
	
	// 마이 페이지 
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage() {
		return "mypage";
	}

	// 회원 가입 
	@PostMapping(value="/register" ,consumes ="application/json")
	@ResponseBody
	public String register(@RequestBody CustomerVO customer) {
		String msg = "";
		String url = RestDomain.restDomain+"/customer/register";
	
		
	
		
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, customer, String.class);
	
		msg = responseEntity.getBody();
		
		return msg;
	}
	
	//카카오 회원가입
	@GetMapping(value="/register2")
	public String registers(HttpServletRequest request,HttpServletResponse response, Map<String,String> map) {
		
		String param1 = "";
		String param2 = "";
		String param3 = "";
		String param4 = "";
		String param5 = "";
		String param6 = "";
		String param7 = "";
		String param8 = "";
		
		Map<String, ?> redirectMap = RequestContextUtils.getInputFlashMap(request);
		if(redirectMap !=null) {
			param1 = (String)redirectMap.get("param1");
			param2 = (String)redirectMap.get("param2");
			param3 = (String)redirectMap.get("param3");
			param4 = (String)redirectMap.get("param4");
			param5 = (String)redirectMap.get("param5");
			param6 = (String)redirectMap.get("param6");
			param7 = (String)redirectMap.get("param7");
			param8 = (String)redirectMap.get("param8");
			
			
		}

		System.out.println("kakao========================="+map);

		String url = RestDomain.restDomain+"/customer/register";
		
		CustomerVO vo = new CustomerVO();
		
		 vo.setId(param1);
		 vo.setPw(param2);
		 vo.setName(param3);
		 vo.setBirthDate(param4);
		 vo.setPhone(param5);
		 vo.setEmail(param6);
		 vo.setGender(param7);
		 vo.setStatus(param8);
		 
		
		
		 System.out.println("vo=========================="+vo);
	
		
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url,vo,String.class);

		
		System.out.println("responseEntity==============="+responseEntity);
		System.out.println("vo=========================="+vo);
		
		
		return "redirect:/main";
	}
	
	
	// 주문 내역 보기 
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/{id}/mypage/orderinfoDetail")
	public ModelAndView readOrderinfo(ModelAndView mav, @PathVariable("id") String id) {
		log.info("사용자 주문 내역 보기================================");
		
		List<OrderInfoVO> list = null;
		String url = RestDomain.restDomain+"/customer/" + id + "/mypage/orderinfo";
		
		ResponseEntity<List> responseEntity = restTemplate.getForEntity(url,java.util.List.class);
		if(responseEntity.getStatusCode()==HttpStatus.OK) {
			list = (List<OrderInfoVO>) responseEntity.getBody();
		}
		
		mav.addObject("orderinfo",list);
		
		mav.setViewName("orderinfoDetail");	
		
		return mav;
	}
	
	// 주문 내역 보기 
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@GetMapping(value = "/{custId}/mypage/orderinfo")
		public ModelAndView readOrder(ModelAndView mav, @PathVariable("custId") String custId) {
			log.info("사용자 주문 내역 보기================================");
			
			List<OrderVO> list = null;
			String url = RestDomain.restDomain+"/customer/" + custId + "/mypage/order";
			
			ResponseEntity<List> responseEntity = restTemplate.getForEntity(url,java.util.List.class);
			if(responseEntity.getStatusCode()==HttpStatus.OK) {
				list = (List<OrderVO>) responseEntity.getBody();
			}
			
			mav.addObject("order",list);
			
			mav.setViewName("orderinfo");	
			
			return mav;
		}

	// 찜 내역 보기 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/fav/{custId}/mypage")
	public ModelAndView readFavorite(ModelAndView mav, @PathVariable("custId") String custId) {
		log.info("사용자 찜 내역 보기================================");
		
		List<FavoriteVO> favorite = null;
		String url = RestDomain.restDomain+"/favorite/" + custId + "/mypage";
		
		ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, java.util.List.class);
		if(responseEntity.getStatusCode()==HttpStatus.OK) {
			favorite = (List<FavoriteVO>) responseEntity.getBody();
		}		
		
		mav.addObject("list",favorite); //뷰에 전달할 데이터 지정 
		
		mav.setViewName("favorite"); //뷰 이름 지정 

		return mav;
	}
	
	// 특정 고객이 특정 가게를 찜했는지 확인하기
	@GetMapping("/fav/{cust_id}/{biz_id}")
	@ResponseBody
	public int isFavoriteChk(@PathVariable("cust_id") String custId, @PathVariable("biz_id") String bizId) {
		log.info(custId + "이/가 " + bizId + "를 찜했는지 확인하기 ================================");
		
		int favorite = 0;
		String url = RestDomain.restDomain+"/favorite/" + custId + "/" + bizId;
		
		ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(url, java.lang.Integer.class);
		if(responseEntity.getStatusCode() == HttpStatus.OK) {
			favorite = responseEntity.getBody();
		}
		return favorite;
	}
	
	// 찜 추가하기
	@PostMapping(value = "/fav/add")
	@ResponseBody
	public int addFavorite(@RequestBody FavoriteVO fav) {
		log.info("찜 추가하기 ================================");
		
		int favorite = 0;
		String url = RestDomain.restDomain+"/favorite/add";
		
		ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, fav, Integer.class);
		favorite = responseEntity.getBody();
		
		return favorite;
	}
	
	// 찜 삭제하기
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/fav/delete/{cust_id}/{biz_id}/{biz_like_cnt}")
	public ResponseEntity deleteFavorite(
				@PathVariable("cust_id") String custId
				, @PathVariable("biz_id") String bizId
				, @PathVariable("biz_like_cnt") int bizLikeCnt
			) {
		log.info(custId + "의 " + bizId + " 찜을 삭제하기 ================================");

		String urlDeleteFav = RestDomain.restDomain+"/favorite/delete/" + custId + "/" + bizId + "/" + bizLikeCnt;
		restTemplate.delete(urlDeleteFav);

		return new ResponseEntity(HttpStatus.OK);
	}
	
	//ID 찾기 
	@PostMapping("/verify")
	@ResponseBody
	public String verify(@RequestBody CustomerVO vo) {
		log.info("Kitchen_Business 사용자 ID 찾기...............................");

		String res = "";
		String url = RestDomain.restDomain+"/customer/verify";
		
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, vo, String.class);
		res = responseEntity.getBody();
		
		log.info("retrieved customer id");
		return res;
	}
	
	// 이메일 인증 처리 
	@GetMapping("/emailConfirm")
	public ModelAndView emailConfirm(ModelAndView mav,@RequestParam("email")String email, @RequestParam("key") String AuthCode) throws UnsupportedEncodingException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email",email);
		map.put("key",AuthCode);
		
		String url = RestDomain.restDomain+"/customer/emailConfirm/";
		int a =0;
		
		ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url,map,Integer.class);
		log.info("들어간다");
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			a = responseEntity.getBody();
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
	
	//카드로 이동
	@RequestMapping(value = "/card", method = RequestMethod.GET)
	public String card() {
		return "card";
	}
	
	// mahout 메뉴id받아오기
	@GetMapping(value = "/recommendation/menu/{bizIdx}")
	@ResponseBody
	public List recommendation(@PathVariable("bizIdx") long bizIdx) {
		System.out.println("프론트 추천받기 : "+bizIdx);
		List result = null;
		String url = RestDomain.restDomain+"/review/recommendation/";
		
		try {
		ResponseEntity<List> responseEntity = restTemplate.getForEntity(url+bizIdx, java.util.List.class);
		result = responseEntity.getBody();
		
		} catch (final HttpClientErrorException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// mahout 메뉴id정보 받아오기
	@GetMapping(value = "/recommendation/info/{menuId}")
	@ResponseBody
	public List menuInfo(@PathVariable("menuId") String bizIdx) {
		System.out.println("프론트 메뉴id보내기 : "+bizIdx);
		List result = null;
		String url = RestDomain.restDomain+"/review/menuRecommendation/";
		
		try {
		ResponseEntity<List> responseEntity = restTemplate.getForEntity(url+bizIdx, java.util.List.class);
		result = responseEntity.getBody();
		
		} catch (final HttpClientErrorException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}