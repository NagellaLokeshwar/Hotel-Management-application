package com.example.springboot4.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot4.models.User;

public interface UserRepository extends JpaRepository<User, String>{
	public Optional<User> findByUsername(String username);
}
