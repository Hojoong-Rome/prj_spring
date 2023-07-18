package com.mycompany.app.common.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CheckLoginSessionInterception extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception{
		
		if(request.getSession().getAttribute("sessionId") != null) {
			// bypass
		} else {
			response.sendRedirect("/mymusic");
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}
}
