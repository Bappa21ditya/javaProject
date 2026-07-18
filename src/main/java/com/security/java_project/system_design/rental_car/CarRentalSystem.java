package com.security.java_project.system_design.rental_car;

import java.time.LocalDateTime;
import java.util.UUID;

public class CarRentalSystem {

    private final Inventory inventory;
    private final PricingStrategy pricingStrategy;
    private final Payment payment;

    public CarRentalSystem() {
        this.inventory = new Inventory();
        this.pricingStrategy = new HourlyPricingStrategy();
        this.payment = new Payment();
    }

    public void addCar(Car car)
    {
        inventory.addCar(car);
    }

    public Reservation bookCar(User user, CarType type)
    {
        Car car=inventory.getAvailableCar(type);
        if (car == null) {
            throw new RuntimeException("No car available");
        }
        car.markUnavailable();
        return new Reservation(UUID.randomUUID().toString(),user,car);
    }
    public void returnCar(Reservation reservation) {
        reservation.completeReservation();
        reservation.getCar().markAvailable();

        double amount = pricingStrategy.calculatePrice(
                reservation.getStartTime(),
                LocalDateTime.now()
        );

        payment.processPayment(amount);

    }


}
