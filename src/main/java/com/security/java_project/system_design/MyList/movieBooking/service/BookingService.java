package com.security.java_project.system_design.MyList.movieBooking.service;
import com.security.java_project.system_design.MyList.movieBooking.entity.User;
import com.security.java_project.system_design.MyList.movieBooking.entity.Show;
import com.security.java_project.system_design.MyList.movieBooking.entity.Seat;

import com.security.java_project.system_design.MyList.movieBooking.entity.Ticket;

import java.util.List;

public interface BookingService {

    Ticket bookTicket(User user, Show show, List<Seat> seats);
}
