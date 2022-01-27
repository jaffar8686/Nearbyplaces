package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserRegister;
import com.example.demo.model.UserPaymentM;
import com.example.demo.repository.UserBookMarkRepository;
import com.example.demo.repository.UserPaymentRepository;
import com.example.demo.repository.UserRegisterRepository;

@Service
public class UserPaymentServiceImpl implements UserPaymentService{

	
	@Autowired 
	private UserPaymentRepository userPaymentRepository;
	
	@Autowired
	private UserRegisterRepository userRegisterRepository;
	
	
	@Override
	public UserPaymentM saveUserSub(UserPaymentM userPay) {
		
		com.example.demo.entity.UserPayment userPayment = new com.example.demo.entity.UserPayment();
		userPayment.setUserName(userPay.getUserName());
		userPayment.setCardNumber(userPay.getCardNumber());
		userPayment.setExpiryDate(userPay.getExpiryDate());
		userPayment.setUserCvv(userPay.getUserCvv());
		userPayment.setPaid(userPay.getPaid());
		UserRegister bpu = userRegisterRepository.findById(userPay.getUserId()).orElseThrow();
		userPayment.setUserRegister(bpu);
		com.example.demo.entity.UserPayment betikid = userPaymentRepository.save(userPayment);
		return userPay;
	}

}
