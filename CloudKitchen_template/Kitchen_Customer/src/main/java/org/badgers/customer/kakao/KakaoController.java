package org.badgers.customer.kakao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class KakaoController {

	 @RequestMapping(value = "/main/kakaologin", produces = "application/json", method = { RequestMethod.GET, RequestMethod.POST })
	    public String kakaoLogin(ModelMap model,@RequestParam("code") String code, RedirectAttributes ra, HttpSession session, HttpServletResponse response) throws IOException {

	    	
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
	        
	        JsonNode  properties = userInfo.path("properties");
	        System.out.println(properties);
	        
	        
	        
	        String id = userInfo.get("id").toString();
	        String email = userInfo.get("kakao_account").get("email").toString();
	        String image = userInfo.get("properties").get("profile_image").toString();
	        String nickname = userInfo.get("properties").get("nickname").toString();

	        System.out.println(id + email);
		
	        session.setAttribute("token", token);
	        session.setAttribute("kid", id);
	        session.setAttribute("kemail", email);
	        session.setAttribute("knikname", nickname);
	      
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
		 
		 JsonNode node = ki.Logout(session.getAttribute("token").toString());
		System.out.println("node==================="+node);
		
		 System.out.println("로그인 후 반환되는 아이디 : " + node.get("id"));

		
		 
		 
		 
		 
		 
		 
		 return "redirect:/http://localhost:3001/customer/main";

		


	



}
}
