package com.akshay.Express_Dine.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.akshay.Express_Dine.entity.Hotel;
import com.akshay.Express_Dine.entity.User;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

	Hotel findByUser(User user);
	
	@Modifying
	@Transactional
	@Query("update Hotel h set h.isOpen = :isOpen where h.hid = :hid")
	int updateIsOpen(boolean isOpen, long hid);
	
}
