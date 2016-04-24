package com.studiomediatech.bugs.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
public class UserController {
	@RequestMapping("/user")
	public String user() {
		return "user";
	}
}
