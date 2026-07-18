package com.security.java_project.system_design.hotelBooking.service;

import com.security.java_project.system_design.hotelBooking.entity.Hotel;
import com.security.java_project.system_design.hotelBooking.entity.Room;
import com.security.java_project.system_design.hotelBooking.entity.RoomBooking;
import com.security.java_project.system_design.hotelBooking.entity.User;

import java.util.ArrayList;
import java.util.List;

public class HotelServiceImpl implements HotelService{

    private List<User> users;

    private List<Hotel> hotels;

    private List<RoomBooking> bookings;
// came from main class
    public HotelServiceImpl(List<User> users, List<Hotel> hotels) {
        this.users = users;
        this.hotels = hotels;
        this.bookings = new ArrayList<>();
    }


    @Override
    public List<Hotel> getAllHotels() {

        return  hotels;
    }

    @Override
    public List<Room> getRoomsByHotel(int hotelId) {
        for(Hotel h: hotels)
        {
            if(h.hotelId==hotelId)
            {
                return h.getRoomList();
            }
        }

        return new ArrayList<>();
    }

    @Override
    public RoomBooking bookRoom(int userId, int roomId) {

        User selectedUser = null;
        Hotel selectedHotel = null;
        Room selectedRoom = null;

        // find user by id
        for (User user : users) {
            if (user.getId() == userId) {
                selectedUser = user;
                break;
            }
        }
        /// Find Hotel and Room
        for(Hotel hotel: hotels)
        {
            for (Room room : hotel.getRoomList()) {
                if(roomId==room.getRoomId())
                {
                    selectedHotel = hotel;
                    selectedRoom = room;
                    break;
                }
            }
        }

        if (selectedUser == null || selectedRoom == null) {
            System.out.println("User or Room not found.");
            return null;
        }

        if (!selectedRoom.isAvailable()) {
            System.out.println("Room is already booked.");
            return null;
        }

        // Mark room booked
        selectedRoom.setAvailable(false);

        RoomBooking booking=new RoomBooking();
        booking.setRoomBookingId((bookings.size() + 1));
        booking.setUser(selectedUser);
        booking.setHotel(selectedHotel);
        booking.setRoom(selectedRoom);
        booking.setTotalPrice(selectedRoom.getPricePerNight());

        bookings.add(booking);

        return booking;
    }

    @Override
    public RoomBooking getBooking(int id) {
        for (RoomBooking booking : bookings) {

            if (booking.getRoomBookingId() == id) {
                return booking;
            }
        }

        return null;
    }
}
