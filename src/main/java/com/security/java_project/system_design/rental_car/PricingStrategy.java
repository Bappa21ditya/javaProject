package com.security.java_project.system_design.rental_car;

import java.time.LocalDateTime;

public interface PricingStrategy {
    double calculatePrice(LocalDateTime start, LocalDateTime end);
}
