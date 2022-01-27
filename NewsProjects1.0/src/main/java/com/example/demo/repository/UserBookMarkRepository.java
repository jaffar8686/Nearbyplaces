package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserBookMark;

public interface UserBookMarkRepository extends JpaRepository<UserBookMark,Integer> {

}
