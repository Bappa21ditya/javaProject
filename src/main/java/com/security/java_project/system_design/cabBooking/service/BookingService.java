package com.security.java_project.system_design.cabBooking.service;

import com.security.java_project.system_design.cabBooking.entity.*;
import com.security.java_project.system_design.cabBooking.enums.RideType;


import java.util.List;

public interface BookingService {

     void searchVehicle(Route route,User user);

    double calculateFare(Route route, RideType rideType);

    public Ride createRide( Route route, User user,Driver driver) ;
}
