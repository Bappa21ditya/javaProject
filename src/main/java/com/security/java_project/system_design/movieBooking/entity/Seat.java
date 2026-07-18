package com.security.java_project.system_design.movieBooking.entity;

import com.security.java_project.system_design.movieBooking.enums.SeatType;

public class Seat {
    public int id;
    public String seatNo;
    public SeatType type;
    public double price;
    public boolean available;

    public Seat(int id, String seatNo, SeatType type, double price, boolean available)
    {
        this.id=id;
        this.seatNo=seatNo;
        this.type=type;
        this.price=price;
        this.available=available;}
}
