package com.security.java_project.system_design.MyList.parkingLot.strategy;
import com.security.java_project.system_design.MyList.parkingLot.entity.Ticket;

public interface PricingStrategy {
    double calculateFare(Ticket ticket);
}
