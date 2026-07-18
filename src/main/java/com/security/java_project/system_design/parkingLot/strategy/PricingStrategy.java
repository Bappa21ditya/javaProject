package com.security.java_project.system_design.parkingLot.strategy;
import com.security.java_project.system_design.parkingLot.entity.Ticket;

public interface PricingStrategy {
    double calculateFare(Ticket ticket);
}
