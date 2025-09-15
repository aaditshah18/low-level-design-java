package com.splitwise.model;

import java.util.List;

public class PercentExpense extends Expense {
    public PercentExpense(double amount, User paidBy, List<Split> splits, String description) {
        super(amount, paidBy, splits, description);
    }

    @Override
    public boolean validate() {
        double totalPercent = 0;

        for (Split split: getSplits()) {
            PercentSplit percentSplit = (PercentSplit) split;
            totalPercent += percentSplit.getPercent();
            split.setAmount(getAmount() * percentSplit.getPercent() / 100.0);
        }
        return Math.abs(totalPercent-100) < 0.01;
    }

}