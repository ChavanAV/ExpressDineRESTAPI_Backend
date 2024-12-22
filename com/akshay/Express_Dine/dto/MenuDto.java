//package com.akshay.Express_Dine.dto;
//
//import java.util.Base64;
//
//import com.akshay.Express_Dine.entity.Menu;
//
//public class MenuDto {
//    private Long mid;
//    private String dishName;
//    private String price;
//    private String duration;
//    private String description;
//    private boolean isSpecial;
//    private boolean isAvail;
//    private String image;
//
//    public MenuDto(Menu menu) {
//        this.mid = menu.getMid();
//        this.dishName = menu.getDishName();
//        this.price = menu.getPrice();
//        this.duration = menu.getDuration();
//        this.description = menu.getDescription();
//        this.isSpecial = menu.getIsSpecial();
//        this.isAvail = menu.getIsAvail();
//        if (menu.getImage() != null) {
//            this.image = Base64.getEncoder().encodeToString(menu.getImage());
//        }
//    }
//
//	public Long getMid() {
//		return mid;
//	}
//
//	public void setMid(Long mid) {
//		this.mid = mid;
//	}
//
//	public String getDishName() {
//		return dishName;
//	}
//
//	public void setDishName(String dishName) {
//		this.dishName = dishName;
//	}
//
//	public String getPrice() {
//		return price;
//	}
//
//	public void setPrice(String price) {
//		this.price = price;
//	}
//
//	public String getDuration() {
//		return duration;
//	}
//
//	public void setDuration(String duration) {
//		this.duration = duration;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public boolean getIsSpecial() {
//		return isSpecial;
//	}
//
//	public void setIsSpecial(boolean isSpecial) {
//		this.isSpecial = isSpecial;
//	}
//
//	public boolean getIsAvail() {
//		return isAvail;
//	}
//
//	public void setIsAvail(boolean isAvail) {
//		this.isAvail = isAvail;
//	}
//
//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}
//    
//    
//}
