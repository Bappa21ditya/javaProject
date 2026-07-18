package com.security.java_project.system_design.movieBooking.service;

import com.security.java_project.system_design.movieBooking.entity.*;
import com.security.java_project.system_design.movieBooking.enums.BookingStatus;

import java.util.List;

public class BookingServiceImpl implements BookingService{

    private EmailNotificationService emailNotificationService;
    private SeatManager seatManager;
    private PricingService pricingService;

   public BookingServiceImpl(EmailNotificationService emailNotificationService,SeatManager seatManager,PricingService pricingService)
    {
       this.emailNotificationService=emailNotificationService;
       this.pricingService=pricingService;
       this.seatManager=seatManager;
    }

    @Override
    public Ticket bookTicket(User user, Show show, List<Seat> seats) {

        if(!seatManager.reserveSeats(show,seats))
        {
            System.out.println("Seats unavilable");
            return null;
        }
        Booking booking=new Booking();
        booking.user=user;
        booking.show=show;
        booking.seats=seats;
        booking.totalAmount=pricingService.calculatePrice(seats);
        booking.status= BookingStatus.CONFIRMED;
        Ticket ticket=new Ticket();
        ticket.booking=booking;
        emailNotificationService.sendEmail(ticket);
        return ticket;
    }
}
