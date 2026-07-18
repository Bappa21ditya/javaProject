package com.security.java_project.system_design.movieBooking.service;
import java.util.*;
import com.security.java_project.system_design.movieBooking.entity.Seat;
public interface PricingService {


        double calculatePrice(List <Seat> seats);

}
