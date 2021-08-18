package com.cos.saveME.service;

//import java.util.HashMap;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.validation.Errors;
//import org.springframework.validation.FieldError;
import com.cos.saveME.model.User;
import com.cos.saveME.reposiotry.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
		
	/*
	 * // 회원가입 시, 유효성 체크 //유효성 검사에 실패한 필드들은 Map 자료구조를 이용하여 키값과 에러 메시지를 응답 //키 :
	 * valid_{dto 필드명} //메시지 : dto에서 작성한 message 값
	 * 
	 * public Map<String, String> validateHandling(Errors errors) { Map<String,
	 * String> validatorResult = new HashMap<>();
	 * 
	 * for (FieldError error : errors.getFieldErrors()) {//유효성 검사에 실패한 필드 목록 String
	 * validKeyName = String.format("valid_%s", error.getField());//유효성 검사에 실패한 필드명
	 * validatorResult.put(validKeyName, error.getDefaultMessage());//유효성 검사에 실패한
	 * 필드에 정의된 메시지 }
	 * 
	 * return validatorResult; }
	 */

    // 회원가입
	@Transactional
	public void join(User user) {
		
		System.out.println(user);
				
		String rawPWD = user.getUserPw();
		String encPWD = encoder.encode(rawPWD);  //해쉬처리
		user.setUserPw(encPWD);
		userRepository.save(user);
	
	}
}
