package com.security.java_project.system_design.hotelBooking;
import com.security.java_project.system_design.hotelBooking.entity.Hotel;
import com.security.java_project.system_design.hotelBooking.entity.Room;
import com.security.java_project.system_design.hotelBooking.entity.RoomBooking;
import com.security.java_project.system_design.hotelBooking.entity.User;
import com.security.java_project.system_design.hotelBooking.enums.HotelType;
import com.security.java_project.system_design.hotelBooking.enums.RoomType;
import com.security.java_project.system_design.hotelBooking.service.HotelService;
import com.security.java_project.system_design.hotelBooking.service.HotelServiceImpl;

import java.util.ArrayList;
import java.util.List;


public class HotelBookingmain {
    public static void main(String[] args) {
    // Create User
    User user = new User(1, "Rahul", "Kolkata");

    List<User> users = new ArrayList<>();
    users.add(user);


    // Create Rooms
    Room room1 = new Room(1, 101, 2500, RoomType.SINGLE, true);
    Room room2 = new Room(2, 102, 4000, RoomType.DELUXE, true);

    List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);

    // Create Hotel
    Hotel hotel = new Hotel(
            1,
            "Taj Hotel",
            "Mumbai",
            HotelType.FIVE_STAR,
            rooms
    );

    List<Hotel> hotels = new ArrayList<>();
        hotels.add(hotel);

    // Create Service
    HotelService hotelService = new HotelServiceImpl(users, hotels);

    // Get Hotels
        System.out.println("Hotels");

        for (Hotel h : hotelService.getAllHotels()) {
        System.out.println(h.getName());
    }

        System.out.println();

    // Get Rooms
        System.out.println("Rooms");

        for (Room room : hotelService.getRoomsByHotel(1)) {
        System.out.println(room.getRoomNumber() + " : " + room.getPricePerNight());
    }

        System.out.println();

    // Book Room
    RoomBooking booking = hotelService.bookRoom(1, 1);

        if (booking != null) {
        System.out.println("Booking Successful");
        System.out.println("Booking Id : " + booking.getRoomBookingId());
        System.out.println("Hotel : " + booking.getHotel().getName());
        System.out.println("Room : " + booking.getRoom().getRoomNumber());
        System.out.println("Price : " + booking.getTotalPrice());
    }

        System.out.println();

    // Get Booking
    RoomBooking savedBooking = hotelService.getBooking(1);

        if (savedBooking != null) {
        System.out.println("Booking Found");
        System.out.println(savedBooking.getHotel().getName());
        System.out.println(savedBooking.getRoom().getRoomNumber());
    }
}
}
