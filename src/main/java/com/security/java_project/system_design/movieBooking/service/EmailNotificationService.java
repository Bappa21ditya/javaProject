package com.security.java_project.system_design.movieBooking.service;

import com.security.java_project.system_design.movieBooking.entity.Ticket;

public interface EmailNotificationService {

    public  void sendEmail(Ticket ticket);
}
