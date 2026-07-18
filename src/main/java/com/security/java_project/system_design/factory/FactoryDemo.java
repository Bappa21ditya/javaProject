package com.security.java_project.system_design.factory;

public class FactoryDemo {

    public static void main(String args[]) {

        Vehicle v1 = VehicleFactory.getVehicle("car");
        v1.drive();

        Vehicle v2 = VehicleFactory.getVehicle("bike");
        v2.drive();


    }


}
