package com.security.java_project.system_design.cabBooking.serviceImpl;

import com.security.java_project.system_design.cabBooking.entity.Driver;
import com.security.java_project.system_design.cabBooking.entity.Ride;
import com.security.java_project.system_design.cabBooking.entity.Route;
import com.security.java_project.system_design.cabBooking.enums.RideType;
import com.security.java_project.system_design.cabBooking.service.BookingService;
import com.security.java_project.system_design.cabBooking.service.DriverService;
import com.security.java_project.system_design.cabBooking.service.PaymentService;
import com.security.java_project.system_design.cabBooking.service.RideService;
import com.security.java_project.system_design.cabBooking.entity.User;
import com.security.java_project.system_design.cabBooking.strategy.PaymentStrategy;

import java.util.List;

public class CabBookingOrchestrator {

private final BookingService bookingService;
private final RideService rideService;
private final DriverService driverService;
private final PaymentService paymentService;


    public CabBookingOrchestrator(BookingService bookingService, RideService rideService, DriverService driverService,PaymentService paymentService) {
        this.bookingService = bookingService;
        this.rideService = rideService;
        this.driverService = driverService;
        this.paymentService=paymentService;
    }

   public void searchVehicle(Route route,User user)
    {
        bookingService.searchVehicle(route,user);
    }
    public List<Driver>  findAvailableDrivers(Route route, RideType rideType)
    {
       return driverService.findAvailableDriver(route,rideType);
    }

     public void notifyDriver(List<Driver>listDriver)
      {
          driverService.notifyDriver(listDriver);
      }
   public Driver acceptRide(List<Driver> listDriver)
    {
        return  driverService.acceptRide(listDriver);
    }
    public Ride createRide(Route route, User user, Driver driver)
    {
        return bookingService.createRide(route,user,driver);
    }
    public void pickup(Ride ride)

    {
        rideService.pickup(ride);
    }
    public void startRide(Ride ride)
    {
        rideService.startRide(ride);
    }
    public void endRide(Ride ride)
    {
        rideService.endRide(ride);
    }

    public void makePayment(Ride ride, PaymentStrategy strategy) {

        paymentService.processPayment(ride.getPayment().getAmount(), strategy );
    }
    public void completeRide(Ride ride) {
       rideService.completeRide(ride);
    }
}

