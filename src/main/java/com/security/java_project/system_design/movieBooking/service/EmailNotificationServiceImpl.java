package com.security.java_project.system_design.movieBooking.service;

import com.security.java_project.system_design.movieBooking.entity.Ticket;

public class EmailNotificationServiceImpl implements EmailNotificationService{
    @Override
    public void sendEmail(Ticket ticket) {
        System.out.println("send emil to user");
    }
}
