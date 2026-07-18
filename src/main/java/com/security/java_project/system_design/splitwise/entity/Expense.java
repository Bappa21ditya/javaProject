package com.security.java_project.system_design.splitwise.entity;

import com.security.java_project.system_design.splitwise.enums.SplitType;

import java.util.List;

public class Expense {

    private int id;

    private double amount;

    private String description;

    private User paidBy;

    private Group group;

    private SplitType splitType;

    private List<Split> splits;

    public Expense(int id,
                   double amount,
                   String description,
                   User paidBy,
                   Group group,
                   SplitType splitType,
                   List<Split> splits) {

        this.id = id;
        this.amount = amount;
        this.description = description;
        this.paidBy = paidBy;
        this.group = group;
        this.splitType = splitType;
        this.splits = splits;

    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public Group getGroup() {
        return group;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public List<Split> getSplits() {
        return splits;
    }
}
