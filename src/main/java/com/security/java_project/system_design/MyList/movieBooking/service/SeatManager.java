package com.security.java_project.system_design.MyList.movieBooking.service;
import com.security.java_project.system_design.MyList.movieBooking.entity.Seat;
import com.security.java_project.system_design.MyList.movieBooking.entity.Show;

import java.util.List;

public interface SeatManager {

    List<Seat> findAvailableSeats(Show show);

    boolean reserveSeats(Show show,List<Seat> seats);

    void releaseSeats(Show show,List<Seat> seats);
}
