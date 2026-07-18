package com.security.java_project.system_design.questions.parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private ParkingSpot[] spots;
    private Map<Integer, Ticket> activeTickets = new HashMap<>();

    public ParkingLot(int size) {
        spots=new ParkingSpot[size];
        for(int i=0;i<3;i++)
        {
           spots[i]=new ParkingSpot(i+1);
        }
    }

    // Park vehicle  // Entry → generate ticket

    public Ticket parkVehicle(Vehicle vehicle) {
        for(ParkingSpot spot:spots)
        {
            if(!spot.isOccupied())
            {
                spot.parkVehicle(vehicle);
              //  System.out.println("Vehicle parked at spot: " + spot.getParkingSpotId());
                Ticket ticket = new Ticket(vehicle, spot);
                activeTickets.put(ticket.getTicketId(), ticket);

                System.out.println("Vehicle parked. Ticket ID: " + ticket.getTicketId());
                return ticket;
            }
        }
        System.out.println("Parking Full!");
        return null;
    }

    // Remove vehicle
    public void removeVehicle(int ticketId) {
//        for(ParkingSpot spot:spots)
//        {
//            if (spot.isOccupied() &&
//                    spot.getVehicle().getVehicleNumber().equals(vehicleNumber)){
//                spot.removeVehicle();
//                System.out.println("Vehicle removed from spot: " + spot.getParkingSpotId());
//                return;
//            }
//        }
//        System.out.println("Vehicle not found!");
        Ticket ticket = activeTickets.get(ticketId);

        if (ticket == null) {
            System.out.println("Invalid Ticket!");
            return;
        }

        ParkingSpot spot = ticket.getSpot();
        spot.removeVehicle();

        // Calculate fee
        LocalDateTime exitTime = LocalDateTime.now();
        long hours = Duration.between(ticket.getEntryTime(), exitTime).toHours();

        if (hours == 0) hours = 1; // minimum charge

        long fee = hours * 10; // ₹10 per hour

        System.out.println("Vehicle exited. Fee: ₹" + fee);

        activeTickets.remove(ticketId);

    }
    // Display free spots
    public void displayAvailableSpots() {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                System.out.println("Spot " + spot.getParkingSpotId()+ " is free");
            }
        }
    }


}
