package com.security.java_project.system_design.MyList.splitwise.service;
import com.security.java_project.system_design.MyList.splitwise.entity.Expense;
import com.security.java_project.system_design.MyList.splitwise.entity.User;

public interface BalanceService {

    void updateBalance(Expense expense);

    void showBalance(User user);

    void showAllBalances();
}
