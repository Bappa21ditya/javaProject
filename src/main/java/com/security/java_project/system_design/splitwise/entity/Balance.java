package com.security.java_project.system_design.splitwise.entity;

public class Balance {

    private User fromUser;

    private User toUser;

    private double amount;

    public Balance(User fromUser,
                   User toUser,
                   double amount) {

        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;

    }

    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
