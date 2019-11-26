package com.practice.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "plain-login";
	}

}
