package com.cos.saveME.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.saveME.auth.PrincipalDetail;

@Controller
public class MainController {

	//
	@GetMapping({"","/"})
	public String index(@AuthenticationPrincipal PrincipalDetail principal) {
		// /WEB-INF/views/index.jsp
		return "index";
	}
	
}
