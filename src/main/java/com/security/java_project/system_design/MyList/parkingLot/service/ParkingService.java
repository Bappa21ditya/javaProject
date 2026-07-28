package com.security.java_project.system_design.MyList.parkingLot.service;

import com.security.java_project.system_design.MyList.parkingLot.entity.ParkingLot;
import com.security.java_project.system_design.MyList.parkingLot.entity.ParkingSpot;
import com.security.java_project.system_design.MyList.parkingLot.entity.Ticket;
import com.security.java_project.system_design.MyList.parkingLot.entity.Vehicle;
import com.security.java_project.system_design.MyList.parkingLot.entity.*;
import com.security.java_project.system_design.MyList.parkingLot.enums.ParkingSpotStatus;
import com.security.java_project.system_design.MyList.parkingLot.strategy.PricingStrategy;

public interface ParkingService {

   public ParkingSpot findAvailiableSpots(Vehicle vehicle, ParkingLot parkingLot);

   public  void markTheSpot(ParkingSpot spot, Vehicle vehicle,ParkingSpotStatus parkingSpotStatus);

   public Ticket generateTicket(Vehicle vehicle, ParkingSpot spot);

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








