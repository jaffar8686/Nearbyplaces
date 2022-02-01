package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserTable;

@Repository
public interface UserRepository extends JpaRepository<UserTable,Integer> {

	UserTable findByEmailId(String email);

}
