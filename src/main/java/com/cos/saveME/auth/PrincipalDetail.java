package com.cos.saveME.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.saveME.model.User;

public class PrincipalDetail implements UserDetails{
	
	private User user;
	
	public PrincipalDetail(User user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getUserPw();
	}

	@Override
	public String getUsername() {
		return user.getUserId();
	}

	// 만료여부
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 잠김여부
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 비밀번호 만료 여부
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정 활성화 여부
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	// 계정 권한
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collecotrs = new ArrayList<>();
		collecotrs.add(()->{return "ROLE_"+user.getUserDiv();});
		
		return collecotrs;
	}
}
