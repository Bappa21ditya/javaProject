package com.security.java_project.system_design.movieBooking.service;

import com.security.java_project.system_design.movieBooking.entity.Seat;

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
