package com.security.java_project.system_design.MyList.movieBooking.service;
import java.util.*;
import com.security.java_project.system_design.MyList.movieBooking.entity.Seat;
public interface PricingService {


        double calculatePrice(List <Seat> seats);

}
