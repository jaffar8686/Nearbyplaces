package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserRegister;
import com.example.demo.model.UserBookMarkM;
import com.example.demo.repository.UserBookMarkRepository;
import com.example.demo.repository.UserRegisterRepository;

@Service
public class UserBookMarkServiceImpl implements UserBookMarkService {

	@Autowired 
	private UserBookMarkRepository userBookMarkRepository;
	
	@Autowired
	private UserRegisterRepository userRegisterRepository;
	
	@Override
	public UserBookMarkM saveUser(UserBookMarkM userBooks) {
		com.example.demo.entity.UserBookMark userBook = new com.example.demo.entity.UserBookMark();
		userBook.setEmailId(userBooks.getEmailId());
		userBook.setUrls(userBooks.getUrls());
		UserRegister bpu = userRegisterRepository.findById(userBooks.getUserId()).orElseThrow();
		userBook.setUserRegister(bpu);
		com.example.demo.entity.UserBookMark betikid = userBookMarkRepository.save(userBook);
		
		return userBooks;
	}

}
