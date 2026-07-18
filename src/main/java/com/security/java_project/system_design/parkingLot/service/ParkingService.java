package com.security.java_project.system_design.parkingLot.service;

import com.security.java_project.system_design.parkingLot.entity.*;
import com.security.java_project.system_design.parkingLot.enums.ParkingSpotStatus;
import com.security.java_project.system_design.parkingLot.strategy.PricingStrategy;

import java.util.ArrayList;
import java.util.List;

public interface ParkingService {

   public ParkingSpot findAvailiableSpots(Vehicle vehicle,ParkingLot parkingLot);

   public  void markTheSpot(ParkingSpot spot, Vehicle vehicle,ParkingSpotStatus parkingSpotStatus);

   public Ticket generateTicket(Vehicle vehicle,ParkingSpot spot);

    double calculateFare(Ticket ticket,
                         PricingStrategy pricingStrategy);

    void freeParkingSpot(ParkingSpot parkingSpot);

    //double calculateFare();
//
//    double fare = parkingService.calculateFare(ticket);
//
//    paymentService.makePayment(fare);
//
//    parkingService.releaseSpot(ticket);
}








