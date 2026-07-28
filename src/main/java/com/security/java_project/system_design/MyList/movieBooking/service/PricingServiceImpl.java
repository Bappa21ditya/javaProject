package com.security.java_project.system_design.MyList.movieBooking.service;

import com.security.java_project.system_design.MyList.movieBooking.entity.Seat;

import java.util.List;

public class PricingServiceImpl implements PricingService{
    @Override
    public double calculatePrice(List<Seat> seats) {
        double t=0;
        for(Seat s:seats)
            t+=s.price;

        return t;
    }
}
