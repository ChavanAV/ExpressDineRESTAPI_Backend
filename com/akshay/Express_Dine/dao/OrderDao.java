package com.akshay.Express_Dine.dao;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akshay.Express_Dine.entity.Hotel;
import com.akshay.Express_Dine.entity.Menu;
import com.akshay.Express_Dine.entity.Order;
import com.akshay.Express_Dine.entity.User;
import com.akshay.Express_Dine.repositiory.OrderRepository;

@Repository
@Transactional
public class OrderDao {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private HotelDao hotelDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private MenuDao menuDao;

	public boolean saveOrder(Order order, long uid, long mid, long hid) {
		System.out.println(order.getDate());
		System.out.println(uid);
		System.out.println(mid);
		System.out.println(hid);

		Hotel hotel = hotelDao.getHotelByHid(hid);
		User user = userDao.findUserById(uid);
		Menu menu = menuDao.findMenu(mid);

		if (hotel != null && user != null && menu != null && user.getRole().equals("No") && menu.getIsAvail()) {
			order.setUser(user);
			order.setMenu(menu);
			List<Order> orders = hotel.getOrders();
			orders.add(order);
			hotel.setOrders(orders);
			Hotel savedHotel = hotelDao.saveHotel(hotel);
			if (savedHotel != null)
				return true;
		}
		return false;
	}

	public List<Order> getUserOrders(long uid) {
		return orderRepository.getUserOrders(uid);
	}

	public List<Order> getHotelOrders(long hid) {
		return orderRepository.getHotelOrders(hid);
	}

	public List<Order> getOrdersOfMenu(Menu menu) {
		return orderRepository.findByMenu(menu);
	}
	
	public void deleteOrersOfMenu(List<Order> orders) {
		orderRepository.deleteAll(orders);
	}

}