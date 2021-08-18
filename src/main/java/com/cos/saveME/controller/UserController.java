package com.cos.saveME.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.cos.saveME.model.User;
import com.cos.saveME.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UserController {
	  
	//private UserService userService;
	
	@GetMapping("/auth/joinSelect")
	public String joinSelect() {
		return "user/joinSelect";
	}
	
	
	@GetMapping("/auth/joinForm")
    public String dispJoin(User user) {
        return "user/joinForm";
    }
	
	/*
	 * @PostMapping("/auth/joinForm") public String execJoin(@Valid User user,
	 * Errors errors, Model model) { if (errors.hasErrors()) { // 회원가입 실패시, 입력 데이터를
	 * 유지 model.addAttribute("user", user);
	 * 
	 * // 유효성 통과 못한 필드와 메시지를 핸들링 Map<String, String> validatorResult =
	 * userService.validateHandling(errors); for (String key :
	 * validatorResult.keySet()) { model.addAttribute(key,
	 * validatorResult.get(key)); }
	 * 
	 * return "user/joinForm"; }
	 * 
	 * userService.join(user); return "redirect:/user/loginForm"; }
	 */
	
	@GetMapping("/auth/joinForm_co")
	public String joinForm_co() {
		return "user/joinForm_co";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
}
