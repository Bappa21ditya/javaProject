package com.security.java_project.system_design.parkingLot.strategy;
import com.security.java_project.system_design.parkingLot.entity.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricingStrategy implements PricingStrategy{
    @Override
    public double calculateFare(Ticket ticket) {

        ticket.setExitTime(LocalDateTime.now());

        long hours =
                Duration.between(ticket.getEntryTime(),
                        ticket.getExitTime()).toHours();

        if(hours == 0){
            hours = 1;
        }

        return hours * 50;
    }
}
