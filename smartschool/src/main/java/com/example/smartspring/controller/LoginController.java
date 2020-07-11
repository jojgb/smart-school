package com.example.smartspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String LoginSiswa() {
		String html = "/login";
		return html;
	}
	@RequestMapping("/signup")
	public String SignUpSiswa() {
		String html = "/signup";
		return html;
	}
}
