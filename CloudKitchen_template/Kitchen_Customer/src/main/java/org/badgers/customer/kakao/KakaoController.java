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

	        // Get id
//	        String id = userInfo.path("id").asText();
	        
	        JsonNode kakao_account = userInfo.path("kakao_account");
	        System.out.println(kakao_account);
	        System.out.println();
	        System.out.println("이거 진짜 : "+kakao_account.get("email").asText());
	        
	        JsonNode  properties = userInfo.path("properties");

	        System.out.println(properties);

	        
	        String id = userInfo.get("id").toString();
	        String email = userInfo.get("kakao_account").get("email").asText();
	        String image = userInfo.get("properties").get("profile_image").asText();
	        String nickname = userInfo.get("properties").get("nickname").asText();

//	        System.out.println(id + email);
	        
	        session.setAttribute("token", token); // 세션 토큰값 저장 
	        session.setAttribute("kid", id); // 세션 id(임시 브라우저마다 다르다고 함) 저장 
	        session.setAttribute("kemail", email); // 세션 email 저장 
	        session.setAttribute("knikname", nickname); // 세션 닉네임 -> 이게id 로 
	        System.out.println(email);
	        model.addAttribute("token",token);
	        model.addAttribute("k_userInfo", userInfo);
	        model.addAttribute("id", id);
	        model.addAttribute("email", email);
	        model.addAttribute("nickname", nickname);
	        model.addAttribute("image", image);

	        return "main";
	    }
	 
	 @RequestMapping(value="main/test",produces="application/json")
	 public String test() {
		 return "test";
	 }
	 
	 @RequestMapping(value = "/logout", produces = "application/json")
	 public String Logout(HttpSession session) {
		 KakaoUserInfo ki = new KakaoUserInfo();

		 
		 JsonNode node = ki.Logout(((JsonNode) session.getAttribute("token")).asText());
		System.out.println("node==================="+node);
		

		 System.out.println("로그인 후 반환되는 아이디 : " + node.get("id"));
		 
		 return "redirect:/http://localhost:3001/customer/main";
	 }
}