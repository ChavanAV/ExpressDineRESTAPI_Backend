package com.akshay.Express_Dine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "menus")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long mid;
	
	@Column(name = "dish_name")
	private String dishName;
	private double price;
	private int duration;
	private String description;
	
	@Column(name = "is_special")
	private boolean isSpecial;	
	
	@Column(name = "is_avail")
	private boolean isAvail;
	
	@Lob
	@Column(name = "image")
	private byte[] image;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JsonIgnore
	private Hotel hotel;

	public long getMid() {
		return mid;
	}

	public void setMid(long mid) {
		this.mid = mid;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsSpecial() {
		return isSpecial;
	}

	public void setIsSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

	public boolean getIsAvail() {
		return isAvail;
	}

	public void setIsAvail(boolean isAvail) {
		this.isAvail = isAvail;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	

}
