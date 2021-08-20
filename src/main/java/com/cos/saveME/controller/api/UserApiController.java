package com.cos.saveME.controller.api;




import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	 * @PostMapping("/auth/joinProc") // user.js에서 ajax문 안에 적은 url 매핑 public
	 * ResponseDto<Integer> save(@RequestBody User user) { // Post방식이기
	 * 때문에 @RequestBody System.out.println("UserApiController:save호출됨");
	 * userService.join(user); return new
	 * ResponseDto<Integer>(HttpStatus.OK.value(), 1); //자바오브젝트를 JSON으로 변환해서
	 * 리턴(Jackson) }
	 */

	
	// user.js에서 ajax문 안에 적은 url 매핑
	@PostMapping("/auth/joinProc")   // Post방식이기 때문에 @RequestBody
	//제네릭 타입에 ?를 넣는건 리턴이 2개인데 2개 다 타입이 다르기 때문에 리턴 타입을 정확히 정의할 수 없어서
	public ResponseDto<?> save(@Valid @RequestBody User user,BindingResult bindingResult) {  
		                      // @Valid 로 RequestBody 데이터를 체크하면 BindingResult에 문제가 있는 결과를 담아줌
		
		
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			//FieldError :문제가 된 코드, 필드 이름, 필드에 정의 된 메세지, 실패 이유 등
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put("valid_"+error.getField(), error.getDefaultMessage());
			}
			
			System.out.println(errorMap);
			
			return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), errorMap);
		}
		
		userService.join(user);
		return new ResponseDto<>(HttpStatus.OK.value(), 1); //자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
	}
	
	
}
