package com.akshay.Express_Dine.controller;

import java.util.Base64;
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

import com.akshay.Express_Dine.dto.ResponseStructure;
import com.akshay.Express_Dine.entity.Menu;
import com.akshay.Express_Dine.service.MenuService;

@RestController
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@PostMapping("/saveMenu/{hid}")
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu, @PathVariable long hid) {
//		System.out.println();
		String base64Image = Base64.getEncoder().encodeToString(menu.getImage());
		byte[] imageBytes = Base64.getDecoder().decode(base64Image);
		menu.setImage(imageBytes);
		return menuService.saveMenu(menu, hid);
//		return null;
	}
	
	@DeleteMapping("/deleteMenu/{mid}")
	public ResponseEntity<ResponseStructure<Boolean>> deleteMenu(@PathVariable long mid){
		return menuService.deleteMenuById(mid);
	}
	
	@GetMapping("/allMenu/{hid}")
	public ResponseEntity<ResponseStructure<List<Menu>>> allMenu(@PathVariable long hid) {
		return menuService.getAllMenu(hid);	
	}
	
	@PutMapping("/updateMenu")
	public ResponseEntity<ResponseStructure<Boolean>> updateMenu(@RequestBody Menu menu) {
		return menuService.updateMenu(menu);
	}	
	
}