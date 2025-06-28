package com.example.springboot4.controller;
import com.example.springboot4.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot4.exceptions.ExceptionHandler;
import com.example.springboot4.models.Hotel;
import com.example.springboot4.models.User;

@RestController
@RequestMapping("/user")
public class UserController {

    private final ExceptionHandler exceptionHandler;

    private final UserService userService;

    @Autowired
    UserController(UserService userService, ExceptionHandler exceptionHandler) {
        this.userService = userService;
        this.exceptionHandler = exceptionHandler;
    }
	
	@PostMapping
	public User newUser(@RequestBody User u) {
		return userService.createUser(u);
	}
	
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") String id)
	{
		return userService.getUserById(id);
	}
	
	@PostMapping("/many")
	public int createMultipleUsers(@RequestBody List<User> ul) {
		return userService.createUserList(ul);
	}
	
	@PutMapping("/update")
	public User updateUserDetails(@RequestBody User u) {
		if(u.getId() == null) {
			throw new RuntimeException("ID is required to update");
		}
		return userService.updateUser(u);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteHotel(@PathVariable("id") String id) {
		return userService.deleteUser(id);
	}
}
