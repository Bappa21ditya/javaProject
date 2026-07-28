package com.security.java_project.system_design.MyList.fooddelivery.entity;

import com.security.java_project.system_design.MyList.fooddelivery.enums.PaymentMethod;
import com.security.java_project.system_design.MyList.fooddelivery.enums.PaymentStatus;

public class Payment {
    private long id;

    private PaymentMethod paymentMethod;

    private PaymentStatus paymentStatus;

    private double amount;

    private String transactionId;
}
