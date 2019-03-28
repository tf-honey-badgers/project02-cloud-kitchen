package org.badgers.business.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.badgers.business.model.BizMemberVOExtend;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j
public class BusinessController {
	@Inject
	RestTemplate restTemplate;

	@GetMapping("/{bizId}/main")
	public ModelAndView readBizMember(ModelAndView mav, @PathVariable("bizId") String bizId) {
		log.info("Kitchen_Business 사업자 개인정보 읽기...............................");

		BizMemberVOExtend returnVal = null;
		String urlBizMember = "http://localhost/rest/business/" + bizId + "/mypage";
		int likeCnt = 0;
		String urlCountFav = "http://localhost/rest/favorite/" + bizId;

		try {
			// 사업자 정보 읽어오기
			ResponseEntity<BizMemberVOExtend> responseEntity = restTemplate.getForEntity(urlBizMember,
					org.badgers.business.model.BizMemberVOExtend.class);
			returnVal = responseEntity.getBody(); // if not HttpStatus.OK -> 위줄에서 바로 예외 발생하여 실행 안된다.
			// 사업자가 받은 찜 횟수 읽어오기
			ResponseEntity<Integer> responseEntityInteger = restTemplate.getForEntity(urlCountFav, Integer.class);
			likeCnt = responseEntityInteger.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}

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

	// pw, account, info, minAmt, bizLiveStrm 수정 가능!
	@PostMapping("/{bizId}/modify")
	@ResponseBody
	public void updateBizMember(@RequestBody BizMemberVOExtend mvo) {
		log.info("Kitchen_Business 사업자 개인정보 수정...............................");

		try {
			String url = "http://localhost/rest/business/" + mvo.getBizId() + "/mypage/modify";
			restTemplate.put(url, mvo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("updateBizMember DONE!!!!!");
	}

	@PostMapping(value = "/", produces = "text/plain; charset=utf-8")
	@ResponseBody
	public ModelAndView login(@RequestBody BizMemberVOExtend mvo, ModelAndView mv, HttpSession session) {
		log.info("Kitchen_Business 사업자 로그인...............................");

		String msg = "";
		String url = "http://localhost/rest/business/";
		String returnVal = "";

		try {
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, mvo, String.class);
			msg = responseEntity.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (msg.equals("BAD_PW")) {
			returnVal = "비밀번호가 틀렸습니다.";
		} else if (msg.equals("NO_ID")) {
			returnVal = "존재하지 않는 아이디입니다.";
		} else if (msg.equals("SERVER_ERROR") || msg.equals("")) {
			returnVal = "서버에 에러가 발생했습니다. 조금 있다가 다시 시도해주세요.";
		} else {
			// 로그인을 유지하기 위한 쿠키 생성
			msg = "성공적으로 로그인했습니다.";
			mv.addObject("isSuccess", true);

			log.info(msg);
			session.setAttribute("login_id", msg);
			returnVal = "성공적으로 로그인했습니다.";
			return mv;
		}

		log.info(returnVal);
	}

	@PostMapping("/verify")
	@ResponseBody
	public String verify(@RequestBody BizMemberVOExtend mvo) {
		log.info("Kitchen_Business 사업자 ID 찾기...............................");

		String res = "";
		String url = "http://localhost/rest/business/verify";

		try {
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, mvo, String.class);
			res = responseEntity.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("retrieved BizId");
		return res;
	}
}