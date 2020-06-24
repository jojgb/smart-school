package com.example.smartspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexTestController {
	@RequestMapping("/indextest")
	public String indextest() {
		String html = "/indextest";
		return html;
	}
}
