package com.security.java_project.system_design.MyList.movieBooking.service;

import com.security.java_project.system_design.MyList.movieBooking.entity.Ticket;

public class EmailNotificationServiceImpl implements EmailNotificationService{
    @Override
    public void sendEmail(Ticket ticket) {
        System.out.println("send emil to user");
    }
}
