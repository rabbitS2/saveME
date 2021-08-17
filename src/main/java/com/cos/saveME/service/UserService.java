package com.cos.saveME.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.saveME.model.RoleType;
import com.cos.saveME.model.User;
import com.cos.saveME.reposiotry.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void join(User user) {
		String rawPWD = user.getUserPw();
		String encPWD = encoder.encode(rawPWD);  //해쉬처리
		user.setUserPw(encPWD);
		user.setUserDiv(RoleType.USER);
		userRepository.save(user);
	}
	
	

}
