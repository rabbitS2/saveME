package com.cos.saveME.reposiotry;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cos.saveME.model.User;



//DAO
//자동으로 bean등록 
@Repository 
//해당 JpaRepository는 User테이블이 관리하는 repository임 / User테이블의 PK는 Integer타입 
public interface UserRepository extends JpaRepository<User, String>{

	
	//User findByUserIdAndUserPw(String userID, String userPW);

	Optional<User> findByUserId(String userId);
}
