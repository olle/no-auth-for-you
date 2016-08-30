package com.studiomediatech.bugs;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggingHandlerInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(LoggingHandlerInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

		logger.debug(" ------------------------------------------ ");
		SecurityContext context = SecurityContextHolder.getContext();
		logger.debug("SecurityContext: {}", context);

		Authentication authentication = Optional.ofNullable(context).map(c -> c.getAuthentication()).orElse(null);
		logger.debug("Authentication: {}", authentication);

		Object principal = Optional.ofNullable(authentication).map(a -> a.getPrincipal()).orElse(null);
		logger.debug("Principal: {}", principal);
	}

}
