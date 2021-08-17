package com.cos.saveME.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.saveME.model.User;
import com.cos.saveME.reposiotry.UserRepository;


@Service // Bean등록
public class PrincipalDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	// 스프링이 로그인 요청을 가로챌 때, name, pwd 변수 2개를 가로챔
	// pwd 부분처리는 알아서 함
	// name이 DB에 있는지만 확인해주면 됨
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		System.out.println("===================================");
		System.out.println(userId);
		System.out.println("===================================");
		
		User principal = userRepository.findByUserId(userId).orElseThrow(() -> {
			return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다 : " + userId);
		});
		return new PrincipalDetail(principal); //시큐리티 세션에 유저 정보가 저장이 됨. 
	}
}
