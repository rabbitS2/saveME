package com.cos.saveME.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
   //@NotBlank(message = "아이디를 입력해주세요")//비어있는 상태로 요청을 보내면 해당 에러메시지
  // @Email()//이메일 형태만 입력 가능
   private String userId; //이메일로 가입
   
  // @NotBlank(message = "비밀번호를 입력해주세요")
  // @Size(min = 4, max = 10, message = "비밀번호는 4자 이상 10자 이하로 입력해주세요.")
  // @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{4,10}",
  // message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 4자 ~ 10자의 비밀번호여야 합니다.")
   @Column(nullable = false,length = 100, name = "user_pw") //해쉬암호화해야함.. 
   private String userPw;
   
  // @NotBlank(message = "이름을 입력해주세요")
   @Column(nullable = false,length = 100, name = "user_name")
   private String userName;
   
  // @NotBlank(message = "닉네임을 입력해주세요")
   @Size(min = 2, max = 10, message = "닉네임은 2자 이상 10자 이하로 입력해주세요.")
   @Column(nullable = false,length = 20, unique = true, name = "user_nick")
   private String userNick;
   
  // @NotBlank(message = "번호를 입력해주세요")
  // @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "'-'제외 입력해주세요")
   @Column(nullable = false,length = 15, name = "user_tel")
   private String userTel;
   
   // @NotBlank(message = "주소를 입력해주세요")
   @Column(length = 100, name = "user_addr")
   private String userAddr;
   
   //주소좌표
   @Column(length = 30,name = "user_x")
   private String userX;
   
   //주소좌표
   @Column(length = 30,name = "user_y")
   private String userY;
   
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
