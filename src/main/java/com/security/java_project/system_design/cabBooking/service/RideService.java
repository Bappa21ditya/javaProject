package com.security.java_project.system_design.cabBooking.service;

import com.security.java_project.system_design.cabBooking.entity.Ride;

public interface RideService {
   void pickup(Ride ride);

   void startRide(Ride ride);

   void  endRide(Ride ride);

   void completeRide( Ride ride);
}
