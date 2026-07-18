package com.security.java_project.system_design.cabBooking.serviceImpl;

import com.security.java_project.system_design.cabBooking.entity.*;
import com.security.java_project.system_design.cabBooking.enums.RideStatus;
import com.security.java_project.system_design.cabBooking.enums.RideType;
import com.security.java_project.system_design.cabBooking.service.BookingService;

import java.util.HashMap;
import java.util.Map;

public class BookingServiceImpl implements BookingService {
    Map<Route, Integer> distanceMap = new HashMap<>();

    public BookingServiceImpl(Map<Route, Integer> distanceMap) {
        this.distanceMap = distanceMap;
    }

    @Override
    public void searchVehicle(Route route, User user) {
        if (!distanceMap.containsKey(route)) {
            System.out.println("root not found ");
        } else {
            Integer distance =
                    distanceMap.get(route);

            Map<RideType, Double> showVehicle = new HashMap<>();

            showVehicle.put(RideType.BIKE,
                    calculateFare(route, RideType.BIKE));

            showVehicle.put(RideType.SHARED_CAB,
                    calculateFare(route, RideType.SHARED_CAB));

            showVehicle.put(RideType.SEDAN,
                    calculateFare(route, RideType.SEDAN));

            System.out.println(showVehicle);

//            showVehicle.put(RideType.BIKE, distance * 5);
//            showVehicle.put(RideType.SEDAN, distance * 20);
//            showVehicle.put(RideType.SHARED_CAB, distance * 12);
//            System.out.println(showVehicle);


        }
    }

    @Override
    public double calculateFare(Route route, RideType rideType) {
        int distance = distanceMap.get(route);

        switch (rideType) {

            case BIKE:
                return distance * 5;

            case SHARED_CAB:
                return distance * 12;

            case SEDAN:
                return distance * 20;

            default:
                throw new IllegalArgumentException("Invalid Ride Type");
        }
    }


    @Override
    public Ride createRide(Route route, User user, Driver driver) {

        RideType rideType = driver.getVehicle().getRideType();

        double amount = calculateFare(route, rideType);

        Payment payment = new Payment(amount);

        Ride ride = new Ride();
        ride.setId(1);
        ride.setUser(user);
        ride.setDriver(driver);
        ride.setVehicle(driver.getVehicle());
        ride.setRoute(route);
        ride.setRideStatus(RideStatus.DRIVER_ASSIGNED);
        ride.setPayment(payment);

        return ride;
    }


}
