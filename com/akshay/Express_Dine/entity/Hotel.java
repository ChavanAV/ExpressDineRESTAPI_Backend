package com.akshay.Express_Dine.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hid;
    	
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private User user;

    @Column(name = "hotel_name", nullable = false)
    private String hotelName;

    @Column(name = "hotel_address", nullable = false)
    private String hotelAdd;

    @Column(name = "station_name", nullable = false)
    private String stationName;

    @Column(name = "is_open", nullable = false)
    private boolean isOpen;
     
    @JsonIgnore
  	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Order> orders;
    
    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Menu> menus;
    
    public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}


    
//    private long uid;

//    @Column(name = "user_name", nullable = false)
//    private String userName;
//
//    @Column(name = "pin", nullable = false)
//    private String pin;

//	public long getUid() {
//		return uid;
//	}
//
//	public void setUid(long uid) {
//		this.uid = uid;
//	}

	public long getHid() {
		return hid;
	}

	public void setHid(long hid) {
		this.hid = hid;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelAdd() {
		return hotelAdd;
	}

	public void setHotelAdd(String hotelAdd) {
		this.hotelAdd = hotelAdd;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getPin() {
//		return pin;
//	}
//
//	public void setPin(String pin) {
//		this.pin = pin;
//	}

//	@Override
//	public String toString() {
//		return "Hotel [hid=" + hid + ", user=" + user + ", hotelName=" + hotelName + ", hotelAdd=" + hotelAdd
//				+ ", stationName=" + stationName + ", isOpen=" + isOpen + ", userName=" + userName + ", pin=" + pin
//				+ "]";
//	}

    
}
