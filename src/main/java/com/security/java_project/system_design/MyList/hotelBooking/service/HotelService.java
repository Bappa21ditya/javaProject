package com.security.java_project.system_design.MyList.hotelBooking.service;

import com.security.java_project.system_design.MyList.hotelBooking.entity.Hotel;
import com.security.java_project.system_design.MyList.hotelBooking.entity.Room;
import com.security.java_project.system_design.MyList.hotelBooking.entity.RoomBooking;

import java.util.List;

public interface HotelService {

    // search all hotels
    List<Hotel> getAllHotels();

    // get hotel by any id
    List<Room> getRoomsByHotel(int hotelId);

    // book the room
    RoomBooking bookRoom(int userId, int roomId);

    // get booking details
    RoomBooking getBooking(int id);


}
