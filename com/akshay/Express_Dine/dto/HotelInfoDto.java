package com.akshay.Express_Dine.dto;

import java.util.List;

import com.akshay.Express_Dine.entity.Menu;

public class HotelInfoDto {
    private Long hid;
    private String hotelName;
    private String hotelAdd;
    private String stationName;
    private boolean isOpen;
//    private List<Menu> menus;

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
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

    public boolean isIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

//    public List<Menu> getMenus() {
//        return menus;
//    }
//
//    public void setMenus(List<Menu> menus) {
//        this.menus = menus;
//    }
}
