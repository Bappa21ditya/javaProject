package com.security.java_project.system_design.parkingLot.strategy;

import com.security.java_project.system_design.parkingLot.entity.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class MinutePricingStrategy implements PricingStrategy{
    @Override
    public double calculateFare(Ticket ticket) {

        ticket.setExitTime(LocalDateTime.now());

//        long minutes =
//                Duration.between(ticket.getEntryTime(),
//                        ticket.getExitTime()).toMinutes();
//
//        return minutes * 2;
        long seconds =
                Duration.between(ticket.getEntryTime(),
                        ticket.getExitTime()).toSeconds();

        return seconds * 2;
    }
}
