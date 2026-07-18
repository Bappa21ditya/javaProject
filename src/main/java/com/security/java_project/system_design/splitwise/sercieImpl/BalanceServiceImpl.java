package com.security.java_project.system_design.splitwise.sercieImpl;

import com.security.java_project.system_design.splitwise.entity.Balance;
import com.security.java_project.system_design.splitwise.entity.Expense;
import com.security.java_project.system_design.splitwise.entity.Split;
import com.security.java_project.system_design.splitwise.entity.User;
import com.security.java_project.system_design.splitwise.service.BalanceService;

import java.util.List;

public class BalanceServiceImpl implements BalanceService {

    private final List<Balance> balances;

    public BalanceServiceImpl(List<Balance> balances) {
        this.balances = balances;
    }

    @Override
    public void updateBalance(Expense expense) {

        User paidBy = expense.getPaidBy();

        for (Split split : expense.getSplits()) {

            User borrower = split.getUser();

            if (borrower.equals(paidBy)) {
                continue;
            }

            updateOrCreateBalance(
                    borrower,
                    paidBy,
                    split.getAmount()
            );
        }

    }

    @Override
    public void showBalance(User user) {
        boolean found = false;

        for (Balance balance : balances) {

            if (balance.getFromUser().equals(user)
                    || balance.getToUser().equals(user)) {

                found = true;

                System.out.println(
                        balance.getFromUser().getName()
                                + " owes "
                                + balance.getToUser().getName()
                                + " : ₹"
                                + balance.getAmount()
                );
            }
        }

        if (!found) {
            System.out.println("No balances found.");
        }

    }

    @Override
    public void showAllBalances() {
        if (balances.isEmpty()) {

            System.out.println("No pending balances.");
            return;
        }

        for (Balance balance : balances) {

            System.out.println(
                    balance.getFromUser().getName()
                            + " owes "
                            + balance.getToUser().getName()
                            + " : ₹"
                            + balance.getAmount()
            );
        }

    }

    private void updateOrCreateBalance(User from,
                                       User to,
                                       double amount) {

        Balance opposite = findBalance(to, from);

        if (opposite != null) {

            if (opposite.getAmount() > amount) {

                opposite.setAmount(
                        opposite.getAmount() - amount
                );
                return;
            }

            if (opposite.getAmount() < amount) {

                balances.remove(opposite);

                balances.add(
                        new Balance(
                                from,
                                to,
                                amount - opposite.getAmount()
                        )
                );
                return;
            }

            balances.remove(opposite);
            return;
        }

        Balance existing = findBalance(from, to);

        if (existing != null) {

            existing.setAmount(
                    existing.getAmount() + amount
            );
            return;
        }

        balances.add(
                new Balance(
                        from,
                        to,
                        amount
                )
        );
    }

    private Balance findBalance(User from,
                                User to) {

        for (Balance balance : balances) {

            if (balance.getFromUser().equals(from)
                    && balance.getToUser().equals(to)) {

                return balance;
            }
        }

        return null;
    }
}
