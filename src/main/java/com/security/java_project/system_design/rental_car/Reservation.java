package com.security.java_project.system_design.rental_car;

import java.time.LocalDateTime;

public class Reservation {
    private final String reservationId;
    private final User user;
    private final Car car;
    private final LocalDateTime startTime;
    private LocalDateTime endTime;
    private ReservationStatus status;

    public Reservation(String reservationId, User user, Car car) {
        this.reservationId = reservationId;
        this.user = user;
        this.car = car;
        this.startTime = LocalDateTime.now();
        this.status = ReservationStatus.BOOKED;
    }
    public Car getCar() {
        return car;
    }

    public void completeReservation()
    {
        this.endTime=LocalDateTime.now();
        this.status=ReservationStatus.COMPLETED;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
}
