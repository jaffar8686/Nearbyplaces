package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserLogged;

public interface UserLoggedRepository extends JpaRepository<UserLogged,Integer>{

	//UserLogged findByEmail_Id(String email);
}
