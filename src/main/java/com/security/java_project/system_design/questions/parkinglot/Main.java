package com.security.java_project.system_design.questions.parkinglot;

public class Main {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(3);

        Vehicle v1 = new Vehicle("WB01A1234", VehicleType.CAR);
      //  Vehicle v2 = new Vehicle("WB02B5678", VehicleType.BIKE);

       // lot.parkVehicle(v1);
        Ticket ticket = lot.parkVehicle(v1);

        // simulate time passing
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lot.removeVehicle(ticket.getTicketId());
      //  lot.parkVehicle(v2);

        lot.displayAvailableSpots();
       // lot.removeVehicle("WB01A1234");

       // lot.displayAvailableSpots();

    }
}
