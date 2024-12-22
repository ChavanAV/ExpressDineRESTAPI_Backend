package com.akshay.Express_Dine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akshay.Express_Dine.dao.HotelDao;
import com.akshay.Express_Dine.dao.UserDao;
import com.akshay.Express_Dine.dto.HotelInfoDto;
import com.akshay.Express_Dine.dto.ResponseStructure;
import com.akshay.Express_Dine.entity.Hotel;
import com.akshay.Express_Dine.entity.User;

@Service
public class HotelService {

	@Autowired
	private HotelDao hotelDao;
	
	@Autowired
	private UserDao userDao;
	
	
	public ResponseEntity<ResponseStructure<Hotel>> saveHotel(Hotel hotel){
		User user = userDao.saveUser(hotel.getUser());
		if(user != null) {
			Hotel returnedHotel = hotelDao.saveHotel(hotel);
			ResponseStructure<Hotel> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Resource created successfully");
			responseStructure.setData(returnedHotel);
			return new ResponseEntity<ResponseStructure<Hotel>>(responseStructure, HttpStatus.CREATED);
		}
		return null;
	}	
	
	public ResponseEntity<ResponseStructure<HotelInfoDto>> getHotelByUid(long uid){
			HotelInfoDto hotel = hotelDao.getHotelByUserUid(uid);
			ResponseStructure<HotelInfoDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Resource retrived successfully");
			responseStructure.setData(hotel);
			return new ResponseEntity<ResponseStructure<HotelInfoDto>> (responseStructure, HttpStatus.OK);
	}
	
	
	public ResponseEntity<ResponseStructure<String>> deleteHotel(long hid){
		String msg = hotelDao.deleteHotel(hid);
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Resource deleted successfully");
		responseStructure.setData(msg);
		return new ResponseEntity<ResponseStructure<String>> (responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Boolean>> updateIsOpenStatus(boolean isOpen, long hid){
		boolean msg = hotelDao.updateIsOpenStatus(isOpen, hid);
		ResponseStructure<Boolean> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Resource updated successfully");
		responseStructure.setData(msg);
		return new ResponseEntity<ResponseStructure<Boolean>> (responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Hotel>> updateHotel(Hotel hotel){
		Hotel returnedHotel = hotelDao.updateHotel(hotel);
		ResponseStructure<Hotel> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Resource retrived successfully");
		responseStructure.setData(returnedHotel);
		return new ResponseEntity<ResponseStructure<Hotel>> (responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<HotelInfoDto>>> getAllHotels(){
		List<HotelInfoDto> allHotels = hotelDao.getAllHotels();
		ResponseStructure<List<HotelInfoDto>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Resource retrived successfully");
		responseStructure.setData(allHotels);
		return new ResponseEntity<ResponseStructure<List<HotelInfoDto>>> (responseStructure, HttpStatus.OK);
	}
}