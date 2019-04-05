package org.badgers.customer.kakao;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
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
			 	HttpServletResponse response
			 ) throws IOException {
		 	System.out.println("kakao code:" +code);

	        // JsonNode 트리형태로 토큰받아온다
	        JsonNode jsonToken = KakaoAccessToken.getKakaoAccessToken(code);
	        
	        System.out.println("jspm토큰==================="+jsonToken);
	        // 여러 json객체 중 access_token을 가져온다
	        JsonNode accessToken = jsonToken.get("access_token");
	        
	        System.out.println("access_token : " + accessToken);
	        
	        // access_token을 통해 사용자 정보 요청
	        JsonNode userInfo = KakaoUserInfo.getKakaoUserInfo(accessToken);
	        
	        System.out.println("userInfo 다 ===============" + userInfo);
	        
	        String token = jsonToken.get("access_token").toString();

	        
	        JsonNode kakao_account = userInfo.path("kakao_account");
	        System.out.println(kakao_account);
	        System.out.println();
	        System.out.println("이거 진짜 : "+kakao_account.get("email").asText());
	        
	        JsonNode  properties = userInfo.path("properties");

	        System.out.println(properties);

	        
	        String ids = userInfo.get("id").toString();
	        String id = userInfo.get("kakao_account").get("email").asText();
	        String image = userInfo.get("properties").get("profile_image").toString();
	        String nickname = userInfo.get("properties").get("nickname").asText();
	       // String gender = userInfo.get("kakao_account").get("gender").asText();
	        
	        
	        String kpw ="kakao";
	        String kbirthDate = "1992-11-11";
	        String kphone = "010";
	    	String kstatus = "MEM002";
	    	String gender = "미정";
	    	session.setAttribute("token",token);
	        session.setAttribute("uid", id); // 세션 email(-> 사용자 id) 저장
	        session.setAttribute("kpw", kpw); //카톡 로그인 비번 
	        session.setAttribute("knikname", nickname);
	        session.setAttribute("kbirthDate", kbirthDate);
	        session.setAttribute("kphone",kphone);
	        session.setAttribute("kemail", id);
	        session.setAttribute("kgender", gender);
	        session.setAttribute("kstatus", kstatus);
	        
	    
	        

		
	
	      return "redirect:/member/register2";
	    }
	 

}