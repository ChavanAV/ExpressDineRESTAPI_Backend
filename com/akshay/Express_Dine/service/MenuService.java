package com.akshay.Express_Dine.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akshay.Express_Dine.dao.MenuDao;
import com.akshay.Express_Dine.dto.ResponseStructure;
import com.akshay.Express_Dine.entity.Menu;

@Service
public class MenuService {
	
	@Autowired
	private MenuDao menuDao;
	
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu, long hid){
//		System.out.println("Received Base64 image: " + new String(menu.getImage()));
//		 if (menu.getImage() != null) {
//		        menu.setImage(Base64.getDecoder().decode(new String(menu.getImage())));
//		    }
		Menu savedMenu = menuDao.saveMenu(menu, hid);
		if(savedMenu != null) {
			ResponseStructure<Menu> res = new ResponseStructure<Menu>();
			res.setStatusCode(HttpStatus.CREATED.value());
			res.setMessage("Resource created successfully");
			res.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(res, HttpStatus.CREATED);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Boolean>> deleteMenuById(long mid){
			boolean removed = menuDao.deleteMenu(mid);
			ResponseStructure<Boolean> resStructure = new ResponseStructure<>();
			resStructure.setStatusCode(HttpStatus.OK.value());
			resStructure.setMessage("Resource deleted successfully");
			resStructure.setData(removed);
			return new ResponseEntity<ResponseStructure<Boolean>>(resStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Menu>>> getAllMenu(long hid){
		List<Menu> menus = menuDao.getAllMenus(hid);
		if(menus != null) {
			ResponseStructure<List<Menu>> res = new ResponseStructure<>();
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Menus retrieved successfully");
			res.setData(menus);
			return new ResponseEntity<ResponseStructure<List<Menu>>>(res, HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Boolean>> updateMenu(Menu menu){
		boolean isUpdated = menuDao.updateMenu(menu);
			ResponseStructure<Boolean> resStructure = new ResponseStructure<>();
			resStructure.setStatusCode(HttpStatus.OK.value());
			resStructure.setMessage("Resource updated successfully");
			resStructure.setData(isUpdated);
			return new ResponseEntity<ResponseStructure<Boolean>>(resStructure, HttpStatus.OK);
	}

}
