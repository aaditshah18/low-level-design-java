package com.splitwise.factory;

import com.splitwise.enums.ExpenseType;
import com.splitwise.model.Expense;
import com.splitwise.model.*;
import com.splitwise.exceptions.InvalidExpenseException;

import java.util.List;

public class ExpenseFactory {
    public static Expense createExpense(
            ExpenseType expenseType,
            double amount,
            User paidBy,
            String description,
            List<Split> splits
    ) {
        switch (expenseType) {
            case EQUAL -> {
                return new EqualExpense(amount, paidBy, splits, description);
            }
            case EXACT -> {
                return new ExactExpense(amount,paidBy, splits, description);
            }
            case PERCENTAGE -> {
                return new PercentExpense(amount, paidBy, splits, description);
            }
            default -> {
                throw new InvalidExpenseException("Invalid expense type entered: " + expenseType);
            }
        }
    }
}