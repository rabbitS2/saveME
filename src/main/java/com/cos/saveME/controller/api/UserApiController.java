package com.cos.saveME.controller.api;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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
	 * @PostMapping("/auth/joinProc") 
	 * public ResponseDto<Integer> save(@RequestBody User user) { 
	 * 
	 * System.out.println("UserApiController:save호출됨");
	 * 
	 * userService.join(user); return new
	 * ResponseDto<Integer>(HttpStatus.OK.value(), 1); //자바오브젝트를 JSON으로 변환해서
	 * 리턴(Jackson) }
	 */
	
	@PostMapping("/auth/joinProc")  // user.js에서 ajax문 안에 적은 url 매핑
	public ResponseDto<Integer> saveChk(@RequestBody User user, BindingResult bindingResult) {
		                               // Post방식이기 때문에 @RequestBody
		System.out.println("에러문 : " + bindingResult);
		if(bindingResult.hasErrors()) {
	            System.out.println(bindingResult);
	            return new ResponseDto<Integer>(500, 1);
	     } 
	    System.out.println("회원가입성공!!");
		userService.join(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
	}
	
	
}
