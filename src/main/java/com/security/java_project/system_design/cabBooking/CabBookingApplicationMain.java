package com.security.java_project.system_design.cabBooking;

import com.security.java_project.system_design.cabBooking.entity.*;
import com.security.java_project.system_design.cabBooking.enums.RideType;
import com.security.java_project.system_design.cabBooking.service.BookingService;
import com.security.java_project.system_design.cabBooking.service.PaymentService;
import com.security.java_project.system_design.cabBooking.service.RideService;
import com.security.java_project.system_design.cabBooking.service.DriverService;
import com.security.java_project.system_design.cabBooking.serviceImpl.*;
import com.security.java_project.system_design.cabBooking.strategy.CashOnDeliveryStrategy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabBookingApplicationMain {
    public static void main(String[] args) {

        // ===========================
        // Locations
        // ===========================

        Location kolkata = new Location("Kolkata");
        Location airport = new Location("Airport");

        // ===========================
        // Route
        // ===========================

        Route route = new Route(kolkata, airport);

        Map<Route, Integer> distanceMap = new HashMap<>();
        distanceMap.put(route, 20);   // 20 KM

        // ===========================
        // User
        // ===========================

        User user = new User();
        user.setId(1);
        user.setName("Bappa");
        user.setLocation(kolkata);

        // ===========================
        // Vehicles
        // ===========================

        Vehicle bike = new Vehicle(1,"wb23", RideType.BIKE);

        Vehicle sedan = new Vehicle(2,"wb24", RideType.SEDAN);

        Vehicle shared = new Vehicle(3, "wb03",RideType.SHARED_CAB);

        // ===========================
        // Drivers
        // ===========================

        Driver driver1 = new Driver();
        driver1.setId(1);
        driver1.setName("Rahul");
        driver1.setLocation(kolkata);
        driver1.setVehicle(bike);

        Driver driver2 = new Driver();
        driver2.setId(2);
        driver2.setName("Amit");
        driver2.setLocation(kolkata);
        driver2.setVehicle(sedan);

        Driver driver3 = new Driver();
        driver3.setId(3);
        driver3.setName("Sourav");
        driver3.setLocation(kolkata);
        driver3.setVehicle(shared);

        List<Driver> driverList = new ArrayList<>();

        driverList.add(driver1);
        driverList.add(driver2);
        driverList.add(driver3);

        // ===========================
        // Services
        // ===========================

        BookingService bookingService =
                new BookingServiceImpl(distanceMap);

        DriverService driverService =
                new DriverServiceImpl(driverList);

        RideService rideService =
                new RideServiceImpl();

        PaymentService paymentService=new PaymentServiceImpl();

        // ===========================
        // Orchestrator
        // ===========================

        CabBookingOrchestrator orchestrator =
                new CabBookingOrchestrator(
                        bookingService,
                        rideService,
                        driverService,
                        paymentService);

        // ===========================
        // Flow
        // ===========================

        System.out.println("========= SEARCH VEHICLE =========");

        orchestrator.searchVehicle( route, user);

        System.out.println();

        System.out.println("========= USER SELECTS BIKE =========");

        List<Driver> availableDrivers =
                orchestrator.findAvailableDrivers(route, RideType.BIKE);

        orchestrator.notifyDriver(availableDrivers);

        Driver acceptedDriver =
                orchestrator.acceptRide(availableDrivers);

        Ride ride =
                orchestrator.createRide(route, user, acceptedDriver);

        System.out.println();

        System.out.println("========= PICKUP =========");

        orchestrator.pickup(ride);

        System.out.println();

        System.out.println("========= START RIDE =========");

        orchestrator.startRide(ride);

        System.out.println();


        orchestrator.endRide(ride);

        System.out.println(ride.getRideStatus());

        System.out.println("payement process");

        orchestrator.makePayment(ride,new CashOnDeliveryStrategy());
        System.out.println("");

        orchestrator.completeRide(ride);

        System.out.println("Final Ride Status : " + ride.getRideStatus());
    }
}
