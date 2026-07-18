package com.security.java_project.system_design.cabBooking.serviceImpl;

import com.security.java_project.system_design.cabBooking.entity.Driver;
import com.security.java_project.system_design.cabBooking.entity.Route;
import com.security.java_project.system_design.cabBooking.enums.RideType;
import com.security.java_project.system_design.cabBooking.service.DriverService;


import java.util.ArrayList;
import java.util.List;

public class DriverServiceImpl implements DriverService{

    List<Driver> driverList=new ArrayList<>();

    public DriverServiceImpl(List<Driver> driverList) {
        this.driverList = driverList;
    }

    @Override
    public void notifyDriver(List<Driver> listDriver) {
        Driver driver=driverList.get(0);
        System.out.println("1st driver gets notified");

    }

    @Override
    public Driver acceptRide(List<Driver> listDriver) {
        System.out.println("1st driver accept it");
        return driverList.get(0);
    }

    @Override
    public List<Driver> findAvailableDriver(Route route, RideType rideType) {
        List<Driver> avaliableDriverList=new ArrayList<>();
        for(Driver driver: driverList)
        {
            if(driver.getVehicle().getRideType()==rideType && driver.getLocation().equals(route.getPickup()))
            {
                avaliableDriverList.add(driver);
            }
        }
        return avaliableDriverList;
    }

}
