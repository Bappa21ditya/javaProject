package com.security.java_project.system_design.MyList.movieBooking.service;

import com.security.java_project.system_design.MyList.movieBooking.entity.Ticket;

public interface EmailNotificationService {

    public  void sendEmail(Ticket ticket);
}
