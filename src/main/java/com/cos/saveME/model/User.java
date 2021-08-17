package com.cos.saveME.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {//유저정보

	@Id //PK
	@Column(length = 50,name = "user_id")
	private String userId; //이메일로 가입
	
	@Column(nullable = false,length = 100, name = "user_pw") //해쉬암호화해야함.. 
	private String userPw;
	
	@Column(nullable = false,length = 100, name = "user_name")
	private String userName;
	
	@Column(nullable = false,length = 20, unique = true, name = "user_nick")
	private String userNick;
			
	@Column(nullable = false,length = 15, name = "user_tel")
	private String userTel;
	
	@Column(length = 100, name = "user_addr")
	private String userAddr;
	
	//주소좌표
	@Column(name = "user_x")
	private int userX;
	
	//주소좌표
	@Column(name = "user_y")
	private int userY;
	
	@Column(length = 1000,name = "user_file")
	private String userFile;
	
	@CreationTimestamp //시간 자동 입력
	@Column(name = "user_date" )
	private Timestamp userDate;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15, name = "user_div")
	private RoleType userDiv;
	
	private String oauth;
	
	@Column(name = "user_point")
	private int userPoint;
	
}
