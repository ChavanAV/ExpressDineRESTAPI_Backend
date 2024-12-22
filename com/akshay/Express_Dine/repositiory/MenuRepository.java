package com.akshay.Express_Dine.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.akshay.Express_Dine.entity.Menu;

@Transactional
public interface MenuRepository extends JpaRepository<Menu, Long>{
	
	@Query("SELECT m FROM Menu m WHERE m.hotel.hid = :hid")
	List<Menu> findAllByHid(long hid);
	
	@Modifying
	@Query("delete from Menu m where m.mid=:mid")
	int deleteByMid(long mid);
}