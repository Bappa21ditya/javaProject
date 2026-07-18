package com.security.java_project.system_design.abstractFactory;

public class TataVehicleFactory implements VehicleFcatory{
    @Override
    public Car createCar() {
        return new TataCar();
    }

    @Override
    public Bike createBike() {
        return new TataBike();
    }
}
