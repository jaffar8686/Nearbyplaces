package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Entertainment;
@Repository
public interface EntertainmentRepository extends JpaRepository<Entertainment,Integer>{

}
