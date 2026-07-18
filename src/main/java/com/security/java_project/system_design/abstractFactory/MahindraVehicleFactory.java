package com.security.java_project.system_design.abstractFactory;

public class MahindraVehicleFactory implements VehicleFcatory{
    @Override
    public Car createCar() {
        return new MahindraCar();
    }

    @Override
    public Bike createBike() {
        return new MahindraBike();
    }
}
