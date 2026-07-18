package com.security.java_project.system_design.cabBooking.service;

import com.security.java_project.system_design.cabBooking.entity.Driver;
import com.security.java_project.system_design.cabBooking.entity.Ride;
import com.security.java_project.system_design.cabBooking.entity.Route;
import com.security.java_project.system_design.cabBooking.enums.RideType;

import java.util.List;

public interface DriverService {

    public void notifyDriver(List<Driver>listDriver) ;


    public Driver acceptRide(List<Driver> listDriver);

    List<Driver> findAvailableDriver(Route route, RideType rideType);
}
