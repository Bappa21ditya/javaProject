package com.security.java_project.system_design.splitwise;
import com.security.java_project.system_design.splitwise.Strategy.SplitStrategyFactory;
import com.security.java_project.system_design.splitwise.entity.*;
import com.security.java_project.system_design.splitwise.enums.SplitType;
import com.security.java_project.system_design.splitwise.sercieImpl.BalanceServiceImpl;
import com.security.java_project.system_design.splitwise.sercieImpl.ExpenseServiceImpl;
import com.security.java_project.system_design.splitwise.sercieImpl.GroupServiceImpl;
import com.security.java_project.system_design.splitwise.sercieImpl.UserServiceImpl;
import com.security.java_project.system_design.splitwise.service.BalanceService;
import com.security.java_project.system_design.splitwise.service.ExpenseService;
import com.security.java_project.system_design.splitwise.service.GroupService;
import com.security.java_project.system_design.splitwise.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class SplitwiseApplication {
    public static void main(String[] args) {

        /*
         * In-Memory Storage
         */
        List<User> users = new ArrayList<>();
        List<Group> groups = new ArrayList<>();
        List<Expense> expenses = new ArrayList<>();
        List<Balance> balances = new ArrayList<>();


        /*
         * Services
         */
        UserService userService =
                new UserServiceImpl(users);

        GroupService groupService =
                new GroupServiceImpl(groups);

        BalanceService balanceService =
                new BalanceServiceImpl(balances);

        SplitStrategyFactory strategyFactory =
                new SplitStrategyFactory();

        ExpenseService expenseService =
                new ExpenseServiceImpl(
                        expenses,
                        balanceService,
                        strategyFactory
                );


        /*
         * Create Users
         */
        User rahul =
                userService.createUser(1, "Rahul");

        User amit =
                userService.createUser(2, "Amit");

        User priya =
                userService.createUser(3, "Priya");


        /*
         * Create Group
         */
        Group goaTrip =
                groupService.createGroup(
                        1,
                        "Goa Trip"
                );


        /*
         * Add Members
         */
        groupService.addMember(goaTrip.getId(), rahul);

        groupService.addMember(goaTrip.getId(), amit);

        groupService.addMember(goaTrip.getId(), priya);


        /*
         * Expense 1
         *
         * Rahul paid ₹900 Dinner
         */
        expenseService.addExpense(
                1,
                900,
                "Dinner",
                rahul,
                goaTrip,
                SplitType.EQUAL
        );


        /*
         * Expense 2
         *
         * Amit paid ₹600 Cab
         */
        expenseService.addExpense(
                2,
                600,
                "Cab",
                amit,
                goaTrip,
                SplitType.EQUAL
        );


        /*
         * Expense 3
         *
         * Priya paid ₹1200 Hotel
         */
        expenseService.addExpense(
                3,
                1200,
                "Hotel",
                priya,
                goaTrip,
                SplitType.EQUAL
        );


        /*
         * Show Expenses
         */
        System.out.println("\n==============================");
        System.out.println("ALL EXPENSES");
        System.out.println("==============================");

        for (Expense expense : expenseService.getAllExpenses()) {

            System.out.println(
                    expense.getDescription()
                            + " : ₹"
                            + expense.getAmount()
                            + " Paid By "
                            + expense.getPaidBy().getName()
            );

        }


        /*
         * Show Balances
         */
        System.out.println("\n==============================");
        System.out.println("ALL BALANCES");
        System.out.println("==============================");

        balanceService.showAllBalances();


        /*
         * Show Rahul Balance
         */
        System.out.println("\n==============================");
        System.out.println("RAHUL BALANCE");
        System.out.println("==============================");

        balanceService.showBalance(rahul);

    }
}
