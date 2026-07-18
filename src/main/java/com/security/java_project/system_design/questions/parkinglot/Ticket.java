package com.security.java_project.system_design.questions.parkinglot;

import java.time.LocalDateTime;

public class Ticket {
    private static int counter = 1;

    private int ticketId;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private ParkingSpot spot;

    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = counter++;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    public int getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public ParkingSpot getSpot() {
        return spot;
    }
}
