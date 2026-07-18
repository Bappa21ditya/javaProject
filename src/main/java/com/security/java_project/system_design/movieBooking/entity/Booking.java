package com.security.java_project.system_design.movieBooking.entity;

import com.security.java_project.system_design.movieBooking.enums.BookingStatus;

import java.util.List;

public class Booking {
    // user, movie,seat,show,status
    public User user;
    public Show show;
    public List<Seat> seats;
    public double totalAmount;
    public BookingStatus status;

}
