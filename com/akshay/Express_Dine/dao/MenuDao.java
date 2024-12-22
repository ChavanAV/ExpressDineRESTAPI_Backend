package com.akshay.Express_Dine.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akshay.Express_Dine.entity.Hotel;
import com.akshay.Express_Dine.entity.Menu;
import com.akshay.Express_Dine.entity.Order;
import com.akshay.Express_Dine.repositiory.MenuRepository;

@Repository
@Transactional
public class MenuDao {

	@Autowired
	private MenuRepository repository;

	@Autowired
	private HotelDao hotelDao;

	@Autowired
	@Lazy
	private OrderDao orderDao;

	public Menu findMenu(long mid) {
		Optional<Menu> menu = repository.findById(mid);
		return menu.isPresent() ? menu.get() : null;
	}

	public Menu saveMenu(Menu menu, long hid) {
		Hotel hotel = hotelDao.getHotelByHid(hid);
		if (hotel != null) {
			List<Menu> menus = hotel.getMenus();
			menus.add(menu);
			menu.setHotel(hotel);
			return repository.save(menu);
		}
		return null;
	}

	public boolean deleteMenu(long mid) {
		Optional<Menu> op = repository.findById(mid);
		if (op.isPresent()) {
			Hotel hotel = op.get().getHotel();
			List<Order> orders = orderDao.getOrdersOfMenu(op.get());
			if (!orders.isEmpty()) {
				for (Order order : orders)
					hotel.getOrders().remove(order);
				orderDao.deleteOrersOfMenu(orders);
			}
			hotel.getMenus().remove(op.get());
			hotelDao.saveHotel(hotel);
			int res = repository.deleteByMid(mid);
			if (res == 0) return true;
		}
		return false;
	}

	public List<Menu> getAllMenus(long hid) {
		return repository.findAllByHid(hid);
	}

	public boolean updateMenu(Menu menu) {
		Menu originalMenu = repository.findById(menu.getMid()).get();

		if (originalMenu != null) {
			menu.setImage(originalMenu.getImage());
			Hotel hotel = originalMenu.getHotel();
			List<Menu> menus = hotel.getMenus();
			menus.remove(originalMenu);
			menus.add(menu);
			hotel.setMenus(menus);
			menu.setHotel(hotel);
			Menu updatedMenu = repository.save(menu);
			if (updatedMenu != null)
				return true;
		}
		return false;
	}

}
