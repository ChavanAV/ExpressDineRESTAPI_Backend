package com.akshay.Express_Dine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akshay.Express_Dine.dao.UserDao;
import com.akshay.Express_Dine.dto.ResponseStructure;
import com.akshay.Express_Dine.entity.Hotel;
import com.akshay.Express_Dine.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user){
		User returnedUser = userDao.saveUser(user);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Resource created successfully");
		responseStructure.setData(returnedUser);
		return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.CREATED);
	}

	
	public ResponseEntity<ResponseStructure<User>> getUser(String userName, String password){
		User returnedUser = userDao.findUser(userName, password);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Resource retrieved successfully");
		responseStructure.setData(returnedUser);
		return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
	}
}
