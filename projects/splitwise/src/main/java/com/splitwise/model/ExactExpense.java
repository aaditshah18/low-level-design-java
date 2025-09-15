package com.splitwise.model;

import java.util.List;


public class ExactExpense extends Expense {
    public ExactExpense(double amount, User paidBy, List<Split> splits, String description) {
        super(amount, paidBy, splits, description);
    }

    @Override
    public boolean validate() {
        // set individual split amount totals nearly same as expected amount
        double expectedAmount = getAmount();
        double total = 0;
        for (Split split: getSplits()){
            total+=split.getAmount();
        }
        return Math.abs(expectedAmount - total) <= 0.01;
    }
}
