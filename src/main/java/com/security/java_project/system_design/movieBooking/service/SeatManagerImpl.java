package com.security.java_project.system_design.movieBooking.service;

import com.security.java_project.system_design.movieBooking.entity.Seat;
import com.security.java_project.system_design.movieBooking.entity.Show;

import java.util.ArrayList;
import java.util.List;

public class SeatManagerImpl implements SeatManager{
    @Override
    public List<Seat> findAvailableSeats(Show show) {
        List<Seat> seats = new ArrayList<>();
        for (Seat s : show.screen.seats)
            if (s.available)
            {
                seats.add(s);
            }
        return seats;
    }

    @Override
    public boolean reserveSeats(Show show, List<Seat> seats) {
        for(Seat s :seats) {
            if (!s.available) {
                return false;
            }
        }
        for(Seat s:seats)
            {
             s.available=false;
            }
        return true;
    }

    @Override
    public void releaseSeats(Show show, List<Seat> seats) {
        for (Seat s:seats)
        {
            s.available=true;
        }
    }
}
