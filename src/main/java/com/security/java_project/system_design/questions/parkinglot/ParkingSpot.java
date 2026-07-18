package com.security.java_project.system_design.questions.parkinglot;

public class ParkingSpot {
    private int  parkingSpotId;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(int parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public  void parkVehicle(Vehicle vehicle)
    {
        this.vehicle=vehicle;
        this.isOccupied=true;
    }
    public void removeVehicle()
    {
        this.vehicle=null;
        this.isOccupied=false;
    }

    public int getParkingSpotId() {
        return parkingSpotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
