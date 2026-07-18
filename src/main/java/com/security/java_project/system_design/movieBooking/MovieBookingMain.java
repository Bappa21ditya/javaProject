package com.security.java_project.system_design.movieBooking;
import com.security.java_project.system_design.movieBooking.entity.User;
import com.security.java_project.system_design.movieBooking.entity.Show;
import com.security.java_project.system_design.movieBooking.entity.Seat;
import com.security.java_project.system_design.movieBooking.entity.Movie;
import com.security.java_project.system_design.movieBooking.entity.Screen;
import com.security.java_project.system_design.movieBooking.entity.Ticket;
import com.security.java_project.system_design.movieBooking.enums.SeatType;
import com.security.java_project.system_design.movieBooking.service.*;

import java.util.ArrayList;
import java.util.List;

public class MovieBookingMain {
    public static void main(String args[])
    {
        User u=new User(1,"Bappa","bappa@gmail.com","99999");

        Movie m=new Movie(1,"Avengers");

        List<Seat> seats=new ArrayList<>();

        seats.add(new Seat(1,"A1", SeatType.GOLD,250,true));

        seats.add(new Seat(2,"A2",SeatType.GOLD,250,true));

        Screen screen=new Screen(1,seats);

        Show show=new Show(1,m,screen);

        BookingService bs=new BookingServiceImpl( new EmailNotificationServiceImpl(), new SeatManagerImpl(), new PricingServiceImpl());

        Ticket t =bs.bookTicket(u,show,seats);

        System.out.println("Status: "+t.booking.status);

        System.out.println("Amount: "+t.booking.totalAmount);


    }
}
