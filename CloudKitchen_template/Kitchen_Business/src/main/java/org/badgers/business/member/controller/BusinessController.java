package org.badgers.business.member.controller;

import javax.inject.Inject;

import org.badgers.business.model.BizMemberVOExtend;
import org.badgers.business.util.RestDomain;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@Controller
@SessionAttributes("bizId")
@RequestMapping("/member")
@Log4j
public class BusinessController {
	@Inject
	RestTemplate restTemplate;
	
/* 사업자용 마이페이지에 정보 뿌리기 */
	@GetMapping("/{bizId}/main")
	public ModelAndView readBizMember(ModelAndView mav, @PathVariable("bizId") String bizId) {
		BizMemberVOExtend returnVal = null;
		String urlBizMember = RestDomain.restDomain+"/business/" + bizId + "/mypage";
		int likeCnt = 0;
		String urlCountFav =  RestDomain.restDomain+"/favorite/" + bizId;
		
		// 사업자 정보 읽어오기
		ResponseEntity<BizMemberVOExtend> responseEntity = restTemplate.getForEntity(urlBizMember,
				org.badgers.business.model.BizMemberVOExtend.class);
		returnVal = responseEntity.getBody(); // if not HttpStatus.OK -> 위줄에서 바로 예외 발생하여 실행 안된다.
		// 사업자가 받은 찜 횟수 읽어오기
		ResponseEntity<Integer> responseEntityInteger = restTemplate.getForEntity(urlCountFav, Integer.class);
		likeCnt = responseEntityInteger.getBody();

		if (returnVal != null) {
			log.info("readBizMember DONE!!!!!");
		} else {
			log.info("Failed to readBizMember. REST server may be offline.");
			mav.addObject("message", "Failed to read biz member data. REST server may be offline.");
		}

		mav.addObject("bizMember", returnVal);
		mav.addObject("favCnt", likeCnt);
		mav.setViewName("mypage");
		
		return mav;
	}

/* 사업자용 마이페이지에서 pw, account, info, minAmt정보 수정하기 */
	@PostMapping("/{bizId}/modify")
	@ResponseBody
	public void updateBizMember(@RequestBody BizMemberVOExtend mvo) {
		String url =  RestDomain.restDomain+"/business/" + mvo.getBizId() + "/mypage/modify";
		restTemplate.put(url, mvo); // RestTemplate put()은 반환값이 void

		log.info("updateBizMember DONE!!!!!");
	}
	
/* 사업자용 마이페이지에서 bizLiveStrm 정보 입력하기 */
	@GetMapping("/livestrm/{bizId}/{bizLiveStrm}")
	@ResponseBody
	public ResponseEntity<String> updateBizLiveStrm(@PathVariable("bizId") String bizId, @PathVariable("bizLiveStrm") String bizLiveStrm) {
		String returnVal = "";
		String url =  RestDomain.restDomain+"/business/livestrm/" + bizId + "/" + bizLiveStrm;
		
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		returnVal = responseEntity.getBody();
		
		log.info("updateBizLiveStrm DONE!!!!!");
		
		return new ResponseEntity<String>(returnVal, HttpStatus.OK);
	}

/* 로그인하기 */ 
	@PostMapping(value ="/login", produces = "text/plain; charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody BizMemberVOExtend mvo, ModelAndView mov){
		HttpHeaders responseHeaders=null;
		String status=""; // 로그인 성공 여부를 알리기 위해 status 문자열 반환
		String url =  RestDomain.restDomain+"/business/login";
		
		try {
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, mvo, String.class);
			status= responseEntity.getBody();
			responseHeaders = new HttpHeaders();
			
			if(status.equals("success")) { responseHeaders.set("RESULT", mvo.getBizId()); }	
		}catch (Exception e) {
			System.out.println(e.getMessage());
			if(e.getMessage().contains("failed: Connection refused: connect")) {
				status="server disconnected";
			}
		}
			
		return new ResponseEntity<>(status, responseHeaders,HttpStatus.OK);	
	}
	
/* 로그아웃하기 */
	@GetMapping("/logout")
	public String logout (Model model) {
		model.addAttribute("msg", "logout");
		return "redirect:/main";
	}

/* ID찾기, 비번 재설정을 위한 본인인증하기 */
	@PostMapping("/verify")
	@ResponseBody
	public String verify(@RequestBody BizMemberVOExtend mvo) {
		String res = "";
		String url =  RestDomain.restDomain+"/business/verify";

		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, mvo, String.class);
		res = responseEntity.getBody();

		log.info("retrieved BizId");
		return res;
	}
}