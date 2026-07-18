package com.security.java_project.system_design.rental_car;

public class Car {
    private final String carId;
    private final CarType carType;
    private boolean available;

    public Car(String carId, CarType carType) {
        this.carId = carId;
        this.carType = carType;
        this.available = true;
    }
    public boolean isAvailable() {
        return available;
    }

    public void markUnavailable() {
        this.available = false;
    }

    public void markAvailable() {
        this.available = true;
    }

    public CarType getCarType() {
        return carType;
    }

    public String getCarId() {
        return carId;
    }
}
