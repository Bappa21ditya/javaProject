package com.security.java_project.system_design.hotelBooking.entity;

import com.security.java_project.system_design.hotelBooking.enums.RoomType;

public class Room {
    int roomId;
    private int roomNumber;
    private double pricePerNight;
    private boolean available;
    RoomType roomType;

    public Room(int roomId,int roomNumber,double pricePerNight,RoomType roomType,boolean available) {
        this.available=available;
        this.pricePerNight=pricePerNight;
        this.roomId=roomId;
        this.roomType=roomType;
        this.roomNumber=roomNumber;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getRoomId() {
        return roomId;
    }
}
