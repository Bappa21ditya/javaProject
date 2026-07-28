package com.security.java_project.system_design.MyList.cabBooking.service;

import com.security.java_project.system_design.MyList.cabBooking.entity.Driver;
import com.security.java_project.system_design.MyList.cabBooking.entity.Ride;
import com.security.java_project.system_design.MyList.cabBooking.entity.Route;
import com.security.java_project.system_design.MyList.cabBooking.entity.User;
import com.security.java_project.system_design.MyList.cabBooking.entity.*;
import com.security.java_project.system_design.MyList.cabBooking.enums.RideType;

public interface BookingService {

     void searchVehicle(Route route, User user);

    double calculateFare(Route route, RideType rideType);

    public Ride createRide(Route route, User user, Driver driver) ;
}
