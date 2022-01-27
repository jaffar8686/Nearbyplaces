package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserPayment;

public interface UserPaymentRepository extends JpaRepository<UserPayment,Integer> {

}
