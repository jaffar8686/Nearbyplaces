package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserRegister;

public interface UserRegisterRepository  extends JpaRepository<UserRegister,Integer>{

	
	UserRegister findByEmailAddress(String email);	
//
//@Query(value="delete from user_book_mark where email_address=:email and urls=:url", nativeQuery = true)
//UserBookMark TrackUSer(@Param("email")String email,@Param("url")String url);

}
