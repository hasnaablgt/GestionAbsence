package com.ensa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
}
