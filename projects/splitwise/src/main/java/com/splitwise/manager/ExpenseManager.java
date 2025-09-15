package com.splitwise.manager;

import com.splitwise.enums.ExpenseType;
import com.splitwise.exceptions.InvalidExpenseException;
import com.splitwise.factory.ExpenseFactory;
import com.splitwise.model.*;

import java.util.*;

/**
 * ExpenseManager handles the core operations of the Splitwise system,
 * including managing users, groups, and expenses. It creates and validates
 * expenses, updates the balance sheet to track how much each user owes
 * another, and provides methods to display outstanding balances.
 */

public class ExpenseManager {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Group> groups = new HashMap<>();
    private final Map<User, Map<User, Double>> balanceSheet = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getId(), user);
        balanceSheet.put(user, new HashMap<>());
    }

    public void addGroup(Group group) {
        groups.put(group.getId(), group);
    }

    public void addExpense(
            ExpenseType expenseType,
            double amount,
            User paidBy,
            List<Split> splits,
            String description,
            Group group
    ) {
        Expense expense = ExpenseFactory.createExpense(expenseType, amount, paidBy, description, splits);

        if (!expense.validate()) {
            throw new InvalidExpenseException("Failed to validate expense");
        }
        group.addExpense(expense);

        // Forming the balance sheet here
        for (Split split: splits) {
            User owedBy = split.getUser();
            if (owedBy.getId().equals(paidBy.getId())) continue;

            balanceSheet.computeIfAbsent(owedBy, k -> new HashMap<>())
                    .put(paidBy,
                            balanceSheet.get(owedBy)
                                            .getOrDefault(paidBy, 0.0) + split.getAmount());
        }
    }

    public void getBalances() {
        System.out.println(balanceSheet);
        for (User user: users.values()) {
            for (Map.Entry<User, Double> entry: balanceSheet.get(user).entrySet()) {
                if (entry.getValue() > 0.0) {
                    System.out.println(user.getName() +
                            " owes " + entry.getKey().getName() + " "
                            + String.format("%.2f", entry.getValue()) + " dinero."
                    );
                }
            }
        }
    }
}