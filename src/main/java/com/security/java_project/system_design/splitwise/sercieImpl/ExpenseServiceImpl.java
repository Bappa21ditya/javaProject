package com.security.java_project.system_design.splitwise.sercieImpl;

import com.security.java_project.system_design.splitwise.Strategy.SplitStrategy;
import com.security.java_project.system_design.splitwise.Strategy.SplitStrategyFactory;
import com.security.java_project.system_design.splitwise.entity.Expense;
import com.security.java_project.system_design.splitwise.entity.Group;
import com.security.java_project.system_design.splitwise.entity.Split;
import com.security.java_project.system_design.splitwise.entity.User;
import com.security.java_project.system_design.splitwise.enums.SplitType;
import com.security.java_project.system_design.splitwise.service.BalanceService;
import com.security.java_project.system_design.splitwise.service.ExpenseService;

import java.util.ArrayList;
import java.util.List;

public class ExpenseServiceImpl implements ExpenseService {

    private final List<Expense> expenses;

    private final BalanceService balanceService;

    private final SplitStrategyFactory strategyFactory;

    public ExpenseServiceImpl(List<Expense> expenses,
                              BalanceService balanceService,
                              SplitStrategyFactory strategyFactory) {

        this.expenses = expenses;
        this.balanceService = balanceService;
        this.strategyFactory = strategyFactory;
    }
    @Override
    public Expense addExpense(int id, double amount, String description, User paidBy, Group group, SplitType splitType) {
        SplitStrategy strategy =
                strategyFactory.getStrategy(splitType);

        List<Split> splits =
                strategy.calculateSplit(
                        amount,
                        group.getMembers()
                );

        Expense expense =
                new Expense(
                        id,
                        amount,
                        description,
                        paidBy,
                        group,
                        splitType,
                        splits
                );

        expenses.add(expense);

        balanceService.updateBalance(expense);

        return expense;
    }

    @Override
    public Expense getExpense(int expenseId) {
        for (Expense expense : expenses) {

            if (expense.getId() == expenseId) {
                return expense;
            }

        }

        return null;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return  expenses;
    }

    @Override
    public List<Expense> getExpensesByGroup(int groupId) {
        List<Expense> result = new ArrayList<>();

        for (Expense expense : expenses) {

            if (expense.getGroup().getId() == groupId) {

                result.add(expense);

            }

        }

        return result;
    }
}
