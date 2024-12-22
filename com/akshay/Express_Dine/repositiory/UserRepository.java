package com.akshay.Express_Dine.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.Express_Dine.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserNameAndPassword(String userName, String password);	
}
