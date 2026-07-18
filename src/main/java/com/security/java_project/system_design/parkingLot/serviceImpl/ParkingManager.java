package com.security.java_project.system_design.parkingLot.serviceImpl;

import com.security.java_project.system_design.parkingLot.entity.*;
import com.security.java_project.system_design.parkingLot.enums.ParkingSpotStatus;
import com.security.java_project.system_design.parkingLot.service.ParkingService;
import com.security.java_project.system_design.parkingLot.strategy.HourlyPricingStrategy;
import com.security.java_project.system_design.parkingLot.strategy.PaymentStrategy;
import com.security.java_project.system_design.parkingLot.strategy.PricingStrategy;
import com.security.java_project.system_design.parkingLot.strategy.CashOnDeliveryStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager {

    private  final ParkingService parkingService;
   private final ParkingLot parkingLot;
    private final PaymentService paymentService;


    public ParkingManager(ParkingService parkingService, PaymentService paymentService,ParkingLot parkingLot ){
        this.parkingService = parkingService;
        this.paymentService = paymentService;
        this.parkingLot=parkingLot;

    }

    public  Ticket parkVehicle(Vehicle vehicle)
    {
        ParkingSpot  selectedSpot= parkingService.findAvailiableSpots(vehicle , parkingLot);
        parkingService.markTheSpot(selectedSpot, vehicle,
                ParkingSpotStatus.OCCUPIED);
        Ticket ticket =
                parkingService.generateTicket(vehicle,
                        selectedSpot);
        return ticket;

    }
   public void exitVehicle(Ticket  ticket,
                     PricingStrategy pricingStrategy,
                     PaymentStrategy paymentStrategy)
    {


        double amount =
                parkingService.calculateFare(
                        ticket,
                        pricingStrategy);


        boolean paymentSuccess =
                paymentService.processPayment(
                        amount,
                        paymentStrategy);

        if(paymentSuccess){

            parkingService.freeParkingSpot(
                    ticket.getParkingSpot());

            System.out.println("Vehicle Exited Successfully");

        }
    }

    //parkVehicle

    //1.find spot
    //2.mark as occupied
    //3.generate ticket


    //exit vehicle
    //4.calculate fare
    //5.payment
    //mark as free
}
