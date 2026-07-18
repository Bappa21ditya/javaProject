package com.security.java_project.system_design.rental_car;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricingStrategy  implements PricingStrategy{
    @Override
    public double calculatePrice(LocalDateTime start, LocalDateTime end) {
        long hours = Duration.between(start, end).toHours() + 1;
        return hours * 500; // ₹500/hour
    }
}
