package com.cos.saveME.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.cos.saveME.model.RoleType;
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
	
	public Map<String, String> validateHandling(Errors errors) {
	        Map<String, String> validatorResult = new HashMap<>();

	        for (FieldError error : errors.getFieldErrors()) {
	            String validKeyName = String.format("valid_%s", error.getField());
	            validatorResult.put(validKeyName, error.getDefaultMessage());
	        }

	        return validatorResult;
	}
	
	@Transactional
	public void join(User user) {
		String rawPWD = user.getUserPw();
		String encPWD = encoder.encode(rawPWD);  //해쉬처리
		user.setUserPw(encPWD);
		userRepository.save(user);
	}
	

}
