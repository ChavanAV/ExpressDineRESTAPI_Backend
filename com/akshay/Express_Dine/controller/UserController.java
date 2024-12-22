package com.akshay.Express_Dine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.Express_Dine.dto.ResponseStructure;
import com.akshay.Express_Dine.entity.Hotel;
import com.akshay.Express_Dine.entity.User;
import com.akshay.Express_Dine.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	
	@GetMapping("/loginUser/{userName}/{password}") 
	public ResponseEntity<ResponseStructure<User>> getUser(@PathVariable String userName, @PathVariable String password) {
		return userService.getUser(userName, password);
	}
	
}
