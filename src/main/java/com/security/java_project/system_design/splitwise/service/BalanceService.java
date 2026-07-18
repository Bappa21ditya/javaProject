package com.security.java_project.system_design.splitwise.service;
import com.security.java_project.system_design.splitwise.entity.Expense;
import com.security.java_project.system_design.splitwise.entity.User;

public interface BalanceService {

    void updateBalance(Expense expense);

    void showBalance(User user);

    void showAllBalances();
}
