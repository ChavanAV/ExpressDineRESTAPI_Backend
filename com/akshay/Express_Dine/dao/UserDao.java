package com.akshay.Express_Dine.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.akshay.Express_Dine.entity.Hotel;
import com.akshay.Express_Dine.entity.User;
import com.akshay.Express_Dine.repositiory.UserRepository;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User findUserById(long id) {
		Optional<User> optional =  userRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	public User findUser(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName, password);
	}
}
