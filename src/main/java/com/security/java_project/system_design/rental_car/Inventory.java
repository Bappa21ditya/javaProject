package com.security.java_project.system_design.rental_car;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public Car getAvailableCar(CarType type) {
        for (Car car : cars) {
            if (car.isAvailable() && car.getCarType() == type) {
                return car;
            }
        }
        return null;
    }
}
