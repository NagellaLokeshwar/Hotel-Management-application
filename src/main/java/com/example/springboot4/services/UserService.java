package com.example.springboot4.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot4.exceptions.ResourceNotFoundException;
import com.example.springboot4.models.Hotel;
import com.example.springboot4.models.User;
import com.example.springboot4.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User createUser(User u) {
		u.setId(UUID.randomUUID().toString());
		return userRepository.save(u);
	}
	
	public int createUserList(List<User> ul) {
		for (User user : ul) {
			user.setId(UUID.randomUUID().toString());
			userRepository.save(user);
		}
		return ul.size();
	}
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User getUserById(String id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}

	
	
	
	public User updateUser(User u) {
		User entity = userRepository.findById(u.getId()).orElseThrow(() -> new ResourceNotFoundException("User with id " + u.getId() + " not found."));
		entity.setUsername(u.getUsername());
		return userRepository.save(entity);
	}
	
	public String deleteUser(String id) {
		User entity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found."));
		userRepository.delete(entity);
		return "User deleted with id: " + id ; 
	}
}
