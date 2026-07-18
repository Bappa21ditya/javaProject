package com.security.java_project.system_design.cabBooking.serviceImpl;

import com.security.java_project.system_design.cabBooking.entity.Ride;
import com.security.java_project.system_design.cabBooking.enums.RideStatus;
import com.security.java_project.system_design.cabBooking.service.RideService;

public class RideServiceImpl implements RideService {

    @Override
    public void pickup(Ride ride) {
        System.out.println("pick is done");
        ride.setRideStatus(RideStatus.DRIVER_ARRIVED);

    }

    @Override
    public void startRide(Ride ride) {
        System.out.println("ride started");
        ride.setRideStatus(RideStatus.IN_PROGRESS);

    }

    @Override
    public void endRide(Ride ride) {
        System.out.println("ride progress");
        ride.setRideStatus(RideStatus.DESTINATION_REACHED);
    }

    @Override
    public void completeRide(Ride ride) {
        System.out.println("ride completed");
        ride.setRideStatus(RideStatus.COMPLETED);
    }
}
