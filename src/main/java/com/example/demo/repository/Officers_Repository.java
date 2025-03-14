package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Officers;
@Repository

public interface Officers_Repository  extends JpaRepository<Officers,Integer>{

	

}
