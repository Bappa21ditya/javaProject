package com.security.java_project.system_design.MyList.parkingLot.serviceImpl;

import com.security.java_project.system_design.MyList.parkingLot.entity.*;
import com.security.java_project.system_design.MyList.parkingLot.enums.ParkingSpotStatus;
import com.security.java_project.system_design.MyList.parkingLot.enums.ParkingSpotType;
import com.security.java_project.system_design.MyList.parkingLot.enums.VehicleType;
import com.security.java_project.system_design.MyList.parkingLot.service.ParkingService;
import com.security.java_project.system_design.MyList.parkingLot.strategy.PricingStrategy;

import java.time.LocalDateTime;

public class ParkingServiceImpl implements ParkingService
{

    @Override
    public ParkingSpot findAvailiableSpots(Vehicle vehicle, ParkingLot parkingLot) {
        for (Floor floor : parkingLot.getFloorList()) {

            for (ParkingSpot parkingSpot : floor.getParkingSpotList()) {

                if (parkingSpot.getParkingSpotStatus() == ParkingSpotStatus.AVAILABLE
                        && canFit(vehicle.getVehicleType(),
                        parkingSpot.getParkingSpotType())) {

                    return parkingSpot;
                }
            }
        }

        return null;
    }

    @Override
    public void markTheSpot(ParkingSpot spot,Vehicle vehicle, ParkingSpotStatus parkingSpotStatus) {
        spot.setParkingSpotStatus(parkingSpotStatus);
        System.out.println("Parking spot Status change to "+parkingSpotStatus);
        spot.setVehicle(vehicle);

    }

    @Override
    public Ticket generateTicket(Vehicle vehicle, ParkingSpot spot) {
        Ticket ticket=new Ticket(1,vehicle,spot, LocalDateTime.now());
        return ticket;
    }

    @Override
    public double calculateFare(Ticket ticket, PricingStrategy pricingStrategy) {
        return pricingStrategy.calculateFare(ticket);

    }

    @Override
    public void freeParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot.setVehicle(null);

        parkingSpot.setParkingSpotStatus(
                ParkingSpotStatus.AVAILABLE);

        System.out.println("Parking Spot is Free");
    }
    private boolean canFit(VehicleType vehicleType,
                           ParkingSpotType parkingSpotType) {

        switch (vehicleType) {

            case BIKE:
                return parkingSpotType == ParkingSpotType.SMALL
                        || parkingSpotType == ParkingSpotType.COMPACT;

            case CAR:
                return parkingSpotType == ParkingSpotType.COMPACT
                        || parkingSpotType == ParkingSpotType.LARGE;

            case TRUCK:
                return parkingSpotType == ParkingSpotType.LARGE;

            default:
                return false;
        }
    }




}
