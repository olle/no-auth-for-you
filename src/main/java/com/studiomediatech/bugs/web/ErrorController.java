package com.studiomediatech.bugs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Used to suppress default (BasicErrorController) functionality: By default
 * Spring Boot adds the error path to the list of paths, ignored by Spring
 * Security.
 */
@Controller
@Profile("fix")
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {
	
	@Autowired
	@Qualifier("requestMappingHandlerMapping")
	private RequestMappingHandlerMapping handlerMapping;

	@RequestMapping(value = "/error")
	public String error(Model model) {
		System.err.println("Custom error controller!");
		return "/error";
	}

	@Override
	public String getErrorPath() {
		return "/__dummyErrorPath";
	}

}
