package com.splitwise.model;

import java.util.List;

public class EqualExpense extends Expense {
    public EqualExpense(double amount, User paidBy, List<Split> splits, String description) {
        super(amount, paidBy, splits, description);
    }

    @Override
    public boolean validate() {
        int totalSplits = this.getSplits().size();
        double splitAmount = this.getAmount()/totalSplits;
        for (Split split: this.getSplits()) {
            split.setAmount(splitAmount);
        }
        return true;
    }
}