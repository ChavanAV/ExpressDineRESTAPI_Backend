package com.akshay.Express_Dine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.Express_Dine.dto.ResponseStructure;
import com.akshay.Express_Dine.entity.Order;
import com.akshay.Express_Dine.entity.User;
import com.akshay.Express_Dine.service.OrderService;


@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
//	@PostMapping("/saveOrder/{hid}")
//	public ResponseEntity<ResponseStructure<Boolean>> saveOrder(@RequestBody Order order, @PathVariable long hid){
//		return orderService.saveOrder(order, hid);
//	}
	
	
	@GetMapping("/getUserOrders/{uid}")
	public ResponseEntity<ResponseStructure<List<Order>>> getUserOrders(@PathVariable long uid){
		return orderService.getUserOrders(uid);
	}
	
	@GetMapping("/getHotelOrders/{hid}")
	public ResponseEntity<ResponseStructure<List<Order>>> getHotelOrders(@PathVariable long hid){
		return orderService.getHotelOrders(hid);
	}
	
	@PostMapping("/saveOrder/{uid}/{mid}/{hid}")
	public ResponseEntity<ResponseStructure<Boolean>> saveOrder(@RequestBody Order order, @PathVariable long uid, @PathVariable long mid, @PathVariable long hid){
		return orderService.saveOrder(order,uid, mid, hid);
	}
	
//	@DeleteMapping("/deleteOrderByMid/{mid}")
//	public ResponseEntity<ResponseStructure<Boolean>> deleteOrder( @PathVariable long mid){
//		return orderService.deleteOrderByMid(mid);
//	}
}
