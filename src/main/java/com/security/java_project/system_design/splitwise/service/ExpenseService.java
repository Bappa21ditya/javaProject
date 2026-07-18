package com.security.java_project.system_design.splitwise.service;

import com.security.java_project.system_design.splitwise.entity.Expense;
import com.security.java_project.system_design.splitwise.entity.Group;
import com.security.java_project.system_design.splitwise.entity.User;
import com.security.java_project.system_design.splitwise.enums.SplitType;

import java.util.List;

public interface ExpenseService {

    Expense addExpense(int id,
                       double amount,
                       String description,
                       User paidBy,
                       Group group,
                       SplitType splitType);

    Expense getExpense(int expenseId);

    List<Expense> getAllExpenses();

    List<Expense> getExpensesByGroup(int groupId);
}
