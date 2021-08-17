package com.cos.saveME.controller.api;


import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.saveME.dto.ResponseDto;
import com.cos.saveME.model.User;
import com.cos.saveME.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	

	/*
	 * @PostMapping("/auth/joinProc") public ResponseDto<Integer> save(@RequestBody
	 * User user) { System.out.println("UserApiController:save호출됨");
	 * 
	 * userService.join(user); return new
	 * ResponseDto<Integer>(HttpStatus.OK.value(), 1); //자바오브젝트를 JSON으로 변환해서
	 * 리턴(Jackson) }
	 */
	
	@GetMapping("/auth/joinProc")
	public ResponseDto<Integer> save(User user) {
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
	}
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> saveChk(@Valid User user, Errors errors, Model model) {
		if(errors.hasErrors()) {
			model.addAttribute("user", user);
			Map<String,String> validatorResult = userService.validateHandling(errors);
			for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }
			
			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);

		}
		userService.join(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
	}
	
	
}
