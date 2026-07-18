package com.security.java_project.system_design.abstractFactory;

public class FactoryProducer {
    public static VehicleFcatory getVehicleFactory(String brand)
    {
        if (brand.equalsIgnoreCase("tata")) {
            return new TataVehicleFactory();
        } else if (brand.equalsIgnoreCase("mahindra")) {
            return new MahindraVehicleFactory();
        }
        return null;
    }

}
