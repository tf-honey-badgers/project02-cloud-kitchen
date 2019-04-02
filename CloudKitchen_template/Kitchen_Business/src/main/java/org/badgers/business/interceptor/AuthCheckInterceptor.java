package org.badgers.business.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;
@Log4j
public class AuthCheckInterceptor extends HandlerInterceptorAdapter{

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final Map<String, String> pathVariables = (Map<String, String>) request
                    .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		//pathvariable 에서 가져온 bizId 값 
		final String uriBizId=pathVariables.get("bizId");
		log.info("uriBizId   : "+uriBizId);
		
		
		HttpSession session = request.getSession();
		log.info(session.getAttribute("bizId"));
		//세션에 저장되어 있는 bizId 값
		String sessionBizId = (String) session.getAttribute("bizId");
		
		
		//세션자체가 null 이면 false 반환
		
		if(session.getAttribute("bizId")==null) {
			log.info("--------------------세션 체크 null-------------------------");
			response.sendRedirect("/business/main?msg=fail");
            return false;
			
		}
		//uriBizId가 null이 아니라면 
		if(uriBizId!=null) {
			//세션은 있는데 세션id랑 pathvariable id랑 비교해서 일치하는지 보여줘야함 
			if(sessionBizId.equals(uriBizId)==false) {
				response.sendRedirect("/business/main?msg=invalidId");
				return false;
			}
		}
		
		return true;
	}
}