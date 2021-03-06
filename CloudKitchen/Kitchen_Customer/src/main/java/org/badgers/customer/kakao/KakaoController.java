package org.badgers.customer.kakao;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.badgers.customer.model.CustomerVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.JsonNode;

@Controller
public class KakaoController {

	 @RequestMapping(value = "/main/kakaologin", produces = "application/json", method = { RequestMethod.GET, RequestMethod.POST })
	 public String kakaoLogin(
			 	ModelMap model,
			 	@RequestParam("code") String code,
			 	RedirectAttributes ra,
			 	HttpSession session,
			 	RedirectAttributes redirectAttr
			 ) throws IOException {
		 	System.out.println("kakao code:" +code);

	        // JsonNode 트리형태로 토큰받아온다
	        JsonNode jsonToken = KakaoAccessToken.getKakaoAccessToken(code);
	       
	        // 여러 json객체 중 access_token을 가져온다
	        JsonNode accessToken = jsonToken.get("access_token");
	        
	        // access_token을 통해 사용자 정보 요청
	        JsonNode userInfo = KakaoUserInfo.getKakaoUserInfo(accessToken);
	        
	        String ids = userInfo.get("id").toString();
	        String id = userInfo.get("kakao_account").get("email").asText();
	        String nickname = userInfo.get("properties").get("nickname").asText();
	        
	        String kpw ="kakao";
	        String kbirthDate = "1992-11-11";
	        String kphone = "010";
	    	String kstatus = "MEM002";
	    	String gender = "미정";
	  
	    	
	    	
	    

	        CustomerVO vo = new CustomerVO();	        
	        
	        vo.setId(ids);
	        vo.setPw(kpw);
	        vo.setName(nickname);
	        vo.setBirthDate(kbirthDate);
	        vo.setPhone(kphone);
	        vo.setEmail(id);
	        vo.setGender(gender);
	        vo.setStatus(kstatus);
	        
	        
	        
	        
	    	redirectAttr.addFlashAttribute("kakaoVO", vo);// id
	    	
	    	
	        

	           return "redirect:/member/register2";
	    }
}