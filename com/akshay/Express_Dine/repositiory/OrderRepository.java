package com.akshay.Express_Dine.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.akshay.Express_Dine.entity.Menu;
import com.akshay.Express_Dine.entity.Order;
import com.akshay.Express_Dine.entity.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
	

	@Query("select o from Order o where o.user.uid = :uid")
	List<Order> getUserOrders(long uid);
	
	@Query("select o from Order o where o.menu.hotel.hid = :hid")
	List<Order> getHotelOrders(long hid);
	
	List<Order> findByMenu(Menu menu);
}
