package com.cos.saveME.controller;


import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cos.saveME.model.User;
import com.cos.saveME.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UserController {
	  
	private UserService userService;
	
	@GetMapping("/auth/joinSelect")
	public String joinSelect() {
		return "user/joinSelect";
	}
		
	@GetMapping("/auth/joinForm")
    public String join(User user) {
        return "user/joinForm";
    }
	

	@GetMapping("/auth/joinForm_co")
	public String joinForm_co() {
		return "user/joinForm_co";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
}
