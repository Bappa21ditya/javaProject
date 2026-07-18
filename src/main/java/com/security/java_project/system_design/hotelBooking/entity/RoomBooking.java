package com.security.java_project.system_design.hotelBooking.entity;

import java.util.List;

public class RoomBooking {
    int roomBookingId;
    User user;
    private Hotel hotel;
    private Room room;

    public int getRoomBookingId() {
        return roomBookingId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Room getRoom() {
        return room;
    }

    private double totalPrice;

    public void setRoomBookingId(int roomBookingId) {
        this.roomBookingId = roomBookingId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
