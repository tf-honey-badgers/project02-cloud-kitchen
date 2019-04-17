package org.badgers.customer.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.badgers.customer.interceptor.AuthCheckInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;

//@Log4j
//public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
//	@Override
//	public boolean preHandle(
//				HttpServletRequest request,
//				HttpServletResponse response,
//				Object handler
//			) throws Exception {
//		String url = "", custId = (String) request.getSession().getAttribute("uid");
//		log.info("UID IS : " + custId);
//		
//		if(request.getQueryString() == null) {
//			if(custId == null) {
//				log.info("------------------------- 로그인 안 한 상태 -------------------------");
//				url = request.getRequestURI().toString() + "?auth=false";
//				log.info(url);
//				response.sendRedirect(url);
//				return false;
//			} else {
//				url = request.getRequestURI().toString() + "?auth=true&custId=" + custId;
//				log.info(url);
//				response.sendRedirect(url);
//			}
//		} else {
//			if(!request.getQueryString().contains("custId")) {
//				if(custId != null) {
//					url = request.getRequestURI().toString() + "?auth=true&custId=" + custId;
//					log.info(url);
//					response.sendRedirect(url);
//				}
//			}
//		}
//		return true;
//	}
//}



@Log4j
public class AuthCheckInterceptor extends HandlerInterceptorAdapter{

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final Map<String, String> pathVariables = (Map<String, String>) request
                    .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		//pathvariable 에서 가져온 bizId 값 
//		final String uriBizId=pathVariables.get("bizId");
//		log.info("URI   : "+pathVariables);
//		log.info("uriBizId   : "+uriBizId);
		log.info("인증 확인 인터셉터");
		HttpSession session = request.getSession();
		//세션에 저장되어 있는 bizId 값
		String sessionuId = (String) session.getAttribute("uid");
		
		
		//세션자체가 null 이면 false 반환
		
		if(sessionuId==null) {
			log.info("--------------------세션  null 체크 메인으로 이동-------------------------");
			response.sendRedirect("/customer/main");
            return false;
		}
		
		//uriBizId가 null이 아니라면 
//		if(sessionuId!=null) {
//			//세션은 있는데 세션id랑 pathvariable id랑 비교해서 일치하는지 보여줘야함 
//			if(sessionBizId.equals(sessionuId)==false) {
//				response.sendRedirect("/business/main?msg=invalidId");
//				return false;
//			}
//		}
		
		return true;
	}
}