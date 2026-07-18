package com.security.java_project.system_design.factory;

public class VehicleFactory {

    public static Vehicle getVehicle(String input)
    {
        if(input ==null)
            return null;
        else if(input.equalsIgnoreCase("car"))
        {

              return new Car();
        }
        else if(input.equalsIgnoreCase("bike"))
        {
             return  new Bike();
        }
        return null;
    }
}
