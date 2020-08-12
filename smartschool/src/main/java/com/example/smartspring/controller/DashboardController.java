package com.example.smartspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	
	@RequestMapping("/dashboard")
	public String Dashboard() {
		String html = "/dashboard";
		return html;
	}
}
