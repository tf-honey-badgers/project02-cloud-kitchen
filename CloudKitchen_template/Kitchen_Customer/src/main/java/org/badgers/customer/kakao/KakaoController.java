package org.badgers.customer.kakao;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	    public String kakaoLogin(ModelMap model,@RequestParam("code") String code, RedirectAttributes ra, HttpSession session, HttpServletResponse response) throws IOException {

	    	
		 	System.out.println("kakao code:" +code);

	        // JsonNode 트리형태로 토큰받아온다
	        JsonNode jsonToken = KakaoAccessToken.getKakaoAccessToken(code);
	        
	        // 여러 json객체 중 access_token을 가져온다
	        JsonNode accessToken = jsonToken.get("access_token");
	        
	        System.out.println("access_token : " + accessToken);
	        
	        // access_token을 통해 사용자 정보 요청
	        JsonNode userInfo = KakaoUserInfo.getKakaoUserInfo(accessToken);
	        
	       
	        System.out.println("userInfo 다 ===============" + userInfo);
	        
	        
	        String token = jsonToken.get("access_token").toString();

	     
	        
	        // Get id
//	        String id = userInfo.path("id").asText();
	        
	        JsonNode kakao_account = userInfo.path("kakao_account");
	        System.out.println(kakao_account);
	        
	        JsonNode  properties = userInfo.path("properties");
	        System.out.println(properties);
	        
	        
	        
	        String id = userInfo.get("id").toString();
	        String email = userInfo.get("kakao_account").get("email").toString();
	        String image = userInfo.get("properties").get("profile_image").toString();
	        String nickname = userInfo.get("properties").get("nickname").toString();

	        System.out.println(id + email);
		
	        session.setAttribute("token", token);
	        session.setAttribute("token", id);
	      
	        model.addAttribute("token",token);
	        model.addAttribute("k_userInfo", userInfo);
	        model.addAttribute("id", id);
	        model.addAttribute("email", email);
	        model.addAttribute("nickname", nickname);
	        model.addAttribute("image", image);

	        return "logininfo";
	   
	    }	
	 @RequestMapping(value="main/test",produces="application/json")
	 public String test() {
		 
		 return "test";
	 }
	 
	 @RequestMapping(value = "/logout", produces = "application/json")
	    public String Logout(HttpSession session) {
	        //KakaoUserInfo 객체 선언

	   
		 
	      //  Object accessToken = null;
//	        
//	        System.out.println("accessToken 1번 ==================="+accessToken);
//	        
	    //    accessToken = session.getAttribute("token");
//	        
//	        //노드에 로그아웃한 결과값음 담아줌 매개변수는 세션에 잇는 token을 가져와 문자열로 변환
//	        
//	        System.out.println("accessToken 2번 ==================="+accessToken);
//	        
//	        
	     //   JsonNode node = KakaoUserInfo.Logout((JsonNode) accessToken);
//	        
//	        
//	        System.out.println("node==================="+node);
//
//	        //결과 값 출력
//	        
//	        System.out.println("로그아웃후 반환되는 아이디 : " + node.get("id"));
	        
	        return "main";
	    }    





}
