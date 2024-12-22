package com.akshay.Express_Dine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akshay.Express_Dine.dao.OrderDao;
import com.akshay.Express_Dine.dto.ResponseStructure;
import com.akshay.Express_Dine.entity.Order;
import com.akshay.Express_Dine.entity.User;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	
	public ResponseEntity<ResponseStructure<Boolean>> saveOrder(Order order, long uid, long mid, long hid){
		boolean isSaved = orderDao.saveOrder(order,uid,mid, hid);
		ResponseStructure<Boolean> res = new  ResponseStructure<Boolean>();
		res.setStatusCode(HttpStatus.CREATED.value());
		res.setMessage("Resource created successfully");
		res.setData(isSaved);
		return new ResponseEntity<ResponseStructure<Boolean>>(res, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Order>>> getUserOrders(long uid){
		List<Order> orders = orderDao.getUserOrders(uid);
		ResponseStructure<List<Order>> res = new  ResponseStructure<>();
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("Resource retrieved successfully");
		res.setData(orders);
		return new ResponseEntity<ResponseStructure<List<Order>>>(res, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Order>>> getHotelOrders(long hid){
		List<Order> orders = orderDao.getHotelOrders(hid);
		ResponseStructure<List<Order>> res = new  ResponseStructure<>();
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("Resource retrieved successfully");
		res.setData(orders);
		return new ResponseEntity<ResponseStructure<List<Order>>>(res, HttpStatus.OK);
	}
	
//	public ResponseEntity<ResponseStructure<Boolean>> deleteOrderByMid(long mid){
//		boolean isSaved = orderDao.deleteOrderByMid(mid);
//		ResponseStructure<Boolean> res = new  ResponseStructure<Boolean>();
//		res.setStatusCode(HttpStatus.OK.value());
//		res.setMessage("Resource deletd successfully");
//		res.setData(isSaved);
//		return new ResponseEntity<ResponseStructure<Boolean>>(res, HttpStatus.OK);
//	}
}
