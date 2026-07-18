package com.security.java_project.system_design.movieBooking.service;
import com.security.java_project.system_design.movieBooking.entity.User;
import com.security.java_project.system_design.movieBooking.entity.Show;
import com.security.java_project.system_design.movieBooking.entity.Seat;

import com.security.java_project.system_design.movieBooking.entity.Ticket;

import java.util.List;

public interface BookingService {

    Ticket bookTicket(User user, Show show, List<Seat> seats);
}
