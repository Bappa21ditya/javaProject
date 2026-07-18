package com.security.java_project.system_design.questions.fooddelivery.entity;

import com.security.java_project.system_design.questions.fooddelivery.enums.PaymentMethod;
import com.security.java_project.system_design.questions.fooddelivery.enums.PaymentStatus;

public class Payment {
    private long id;

    private PaymentMethod paymentMethod;

    private PaymentStatus paymentStatus;

    private double amount;

    private String transactionId;
}
