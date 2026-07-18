package com.security.java_project.system_design.hotelBooking.entity;

import com.security.java_project.system_design.hotelBooking.enums.HotelType;

import java.util.List;

public class Hotel {

   public int hotelId;
   public List<Room> roomList;
    String address;
    String name;
    HotelType hotelType;

    public String getName() {
        return name;
    }

    public Hotel(int hotelId, String name, String address, HotelType hotelType, List<Room> roomList) {
        this.hotelId = hotelId;
        this.roomList=roomList;
        this.address=address;
        this.hotelType=hotelType;
        this.name=name;
    }

    public List<Room> getRoomList() {
        return roomList;
    }
}
