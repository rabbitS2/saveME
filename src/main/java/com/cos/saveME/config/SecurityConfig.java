package com.cos.saveME.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.saveME.auth.PrincipalDetail;
import com.cos.saveME.auth.PrincipalDetailService;


@Configuration   // 빈등록 (IoC 관리)
@EnableWebSecurity  // 시큐리티 필터 등록
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private PrincipalDetailService principalDetailService;

	@Bean //Ioc
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable() //csrf 토큰 비활성화
			.authorizeRequests() //request가 들어오면!
				.antMatchers("/","/auth/**", "/js/**","/css/**","/images/**","/webfonts/**")  // auth밑의 주소들은
				.permitAll()    // 로그인 없이 들어 올 수 있음
				.anyRequest()  // 위의 request가 아닌 다른 request 들은
				.authenticated() // 로그인이 필요함
			.and()
				.formLogin() // 로그인이 필요할 경우
				.loginPage("/auth/loginForm") // 해당 페이지가 열림
				.loginProcessingUrl("/auth/loginProc")// 시큐리티가 해당 주소로 오는 로그인을 가로채서 대신 로그인
				.defaultSuccessUrl("/") // 정상적으로 작동되면 해당 주소 실행 
				.failureUrl("/auth/loginForm"); // 로그인이 실패하면 해당 주소 실행
		
	}

	
}
