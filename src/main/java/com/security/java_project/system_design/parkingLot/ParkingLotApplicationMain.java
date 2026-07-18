package com.security.java_project.system_design.parkingLot;

import com.security.java_project.system_design.parkingLot.entity.*;
import com.security.java_project.system_design.parkingLot.entity.ParkingLot;
import com.security.java_project.system_design.parkingLot.entity.ParkingSpot;
import com.security.java_project.system_design.parkingLot.enums.ParkingSpotStatus;
import com.security.java_project.system_design.parkingLot.enums.ParkingSpotType;
import com.security.java_project.system_design.parkingLot.enums.VehicleType;
import com.security.java_project.system_design.parkingLot.service.ParkingService;
import com.security.java_project.system_design.parkingLot.serviceImpl.ParkingManager;
import com.security.java_project.system_design.parkingLot.serviceImpl.ParkingServiceImpl;
import com.security.java_project.system_design.parkingLot.serviceImpl.PaymentService;
import com.security.java_project.system_design.parkingLot.strategy.CashOnDeliveryStrategy;
import com.security.java_project.system_design.parkingLot.strategy.MinutePricingStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotApplicationMain {

    public static void main(String[] args) {

        // -------------------------
        // Create Parking Spots
        // -------------------------

        ParkingSpot spot1 =
                new ParkingSpot(1,
                        ParkingSpotType.SMALL,
                        ParkingSpotStatus.AVAILABLE);

        ParkingSpot spot2 =
                new ParkingSpot(2,
                        ParkingSpotType.COMPACT,
                        ParkingSpotStatus.AVAILABLE);

        ParkingSpot spot3 =
                new ParkingSpot(3,
                        ParkingSpotType.LARGE,
                        ParkingSpotStatus.AVAILABLE);

        List<ParkingSpot> parkingSpotList = new ArrayList<>();

        parkingSpotList.add(spot1);
        parkingSpotList.add(spot2);
        parkingSpotList.add(spot3);

        // -------------------------
        // Floor
        // -------------------------

        Floor floor =
                new Floor(1, parkingSpotList);

        List<Floor> floorList = new ArrayList<>();
        floorList.add(floor);

        // -------------------------
        // Parking Lot
        // -------------------------

        ParkingLot parkingLot =
                new ParkingLot(1, floorList);

        // -------------------------
        // Services
        // -------------------------

        ParkingService parkingService =
                new ParkingServiceImpl();

        PaymentService paymentService =
                new PaymentService();

        ParkingManager parkingManager =
                new ParkingManager(
                        parkingService,
                        paymentService,
                        parkingLot);

        // -------------------------
        // Vehicle
        // -------------------------

        Vehicle vehicle =
                new Vehicle(
                        1,
                        "WB24AB1234",
                        VehicleType.CAR);

        // -------------------------
        // Park Vehicle
        // -------------------------

        Ticket ticket =
                parkingManager.parkVehicle(vehicle);

        System.out.println("----------------------");

        System.out.println("Ticket Generated");

        System.out.println("Vehicle : "
                + ticket.getVehicle().getVehicleNumber());

        System.out.println("Spot Id : "
                + ticket.getParkingSpot().getId());

        // Wait for testing fare calculation

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------");

        // -------------------------
        // Exit Vehicle
        // -------------------------

        parkingManager.exitVehicle(
                ticket,
                new MinutePricingStrategy(),
                new CashOnDeliveryStrategy());
    }
}
