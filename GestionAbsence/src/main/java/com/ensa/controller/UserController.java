package com.ensa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entity.User;
import com.ensa.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/users")
	public List<User> getAllusers() {
		return userService.getAllUsers();
	}

	
	@PostMapping("/users/add")
	public User addUser(@Valid @RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userService.saveOrUpdateUser(user);
	}
	
	@GetMapping("/users/{Id}")
	public User getUserById(@PathVariable("Id") Long id) {
		return userService.getUserById(id);
	}
	
	@DeleteMapping("/users/delete/{Id}")
	public void deleteUser(@PathVariable("Id") Long id) {
		userService.deleteUser(id);
	}
	
}
