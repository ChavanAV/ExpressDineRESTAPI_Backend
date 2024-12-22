package com.akshay.Express_Dine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.Express_Dine.dto.HotelInfoDto;
import com.akshay.Express_Dine.dto.ResponseStructure;
import com.akshay.Express_Dine.entity.Hotel;
import com.akshay.Express_Dine.entity.User;
import com.akshay.Express_Dine.service.HotelService;
import com.akshay.Express_Dine.service.UserService;

@RestController
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/registerHotelWithUser")
	public ResponseEntity<ResponseStructure<Hotel>> saveUserWithHotel(@RequestBody Hotel hotel) {
		return hotelService.saveHotel(hotel);
	}
	
	
//	public ResponseEntity<ResponseStructure<Hotel>> getHotelDetails(@PathVariable long uid){
//		return hotelService.getHotelByUid(uid);
//	}
	
	@GetMapping("/getHotelDetails/{uid}")
	public ResponseEntity<ResponseStructure<HotelInfoDto>> getHotelDetails(@PathVariable long uid){
		return hotelService.getHotelByUid(uid);
	}
	
	@DeleteMapping("/deleteHotel/{hid}")
	public ResponseEntity<ResponseStructure<String>> deleteHotel(@PathVariable long hid){
		return hotelService.deleteHotel(hid);
	}
	
	@PutMapping("/updateIsOpen/{isOpen}/{hid}")
	public ResponseEntity<ResponseStructure<Boolean>> updateIsOpen(@PathVariable boolean isOpen, @PathVariable long hid){
		return hotelService.updateIsOpenStatus(isOpen, hid);
	}	
	
	@PutMapping("/updateHotel")
	public ResponseEntity<ResponseStructure<Hotel>> updateHotel(@RequestBody Hotel hotel) {
		return hotelService.updateHotel(hotel);
	}
	
	@GetMapping("/getAllHotels")
	public ResponseEntity<ResponseStructure<List<HotelInfoDto>>> getAllHotels(){
		return hotelService.getAllHotels();
	}
}