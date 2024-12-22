package com.akshay.Express_Dine.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akshay.Express_Dine.dto.HotelInfoDto;
import com.akshay.Express_Dine.entity.Hotel;
import com.akshay.Express_Dine.entity.User;
import com.akshay.Express_Dine.repositiory.HotelRepository;
import com.akshay.Express_Dine.repositiory.UserRepository;

@Repository
@Transactional
public class HotelDao {

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private UserDao userDao;

	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}


	public Hotel getHotelByHid(long hid) {
		Optional<Hotel> op = hotelRepository.findById(hid);
		if (op.isPresent()) {
			return op.get();
		}
		return null;
	}
	
	public HotelInfoDto getHotelByUserUid(long uid) {
		Hotel hotel = hotelRepository.findByUser(userDao.findUserById(uid));
		HotelInfoDto newHotel = new HotelInfoDto();
		newHotel.setHid(hotel.getHid());
		newHotel.setHotelName(hotel.getHotelName());
		newHotel.setStationName(hotel.getStationName());
		newHotel.setHotelAdd(hotel.getHotelAdd());
		newHotel.setIsOpen(hotel.getIsOpen());
		if (newHotel != null) {
			return newHotel;
		}
		return null;
	}

	public String deleteHotel(long hid) {
		Hotel hotel = hotelRepository.findById(hid).get();
		if (hotel != null) {
			User user = hotel.getUser();
			if (user != null) {
				user.setRole("No");
				userDao.saveUser(user);
			}
			hotelRepository.deleteById(hid);

			return "Hotel Deleted Successfully";
		}
		return "Hotel not present";
	}

	public boolean updateIsOpenStatus(boolean isOpen, long hid) {
		int res = hotelRepository.updateIsOpen(isOpen, hid);
		if(res != 0) return true;
		return false;
////		Hotel hotel = hotelRepository.findById(hid).get();
//		if (isOpen != null) {
////			hotelRepository.save(hotel);
////			if (res != 0)
//				return true;
//		}
//		return false;
	}

	public Hotel updateHotel(Hotel hotel) {
		Hotel originalHotel = getHotelByHid(hotel.getHid());
		originalHotel.setHotelName(hotel.getHotelName());
		originalHotel.setHotelAdd(hotel.getHotelAdd());
		originalHotel.setStationName(hotel.getStationName());
		return hotelRepository.save(originalHotel);
	}
	
	public List<HotelInfoDto> getAllHotels(){
		List<HotelInfoDto> hotelList = new ArrayList<HotelInfoDto>();
		for(Hotel hotel : hotelRepository.findAll()) {
			HotelInfoDto hotelInfoDto = new HotelInfoDto();
			hotelInfoDto.setHid(hotel.getHid());
			hotelInfoDto.setHotelName(hotel.getHotelName());
			hotelInfoDto.setHotelAdd(hotel.getHotelAdd());
			hotelInfoDto.setStationName(hotel.getStationName());
			hotelInfoDto.setIsOpen(hotel.getIsOpen());
//			hotelInfoDto.setMenus(hotel.getMenus());
			hotelList.add(hotelInfoDto);
		}
		return hotelList;
	}

}
