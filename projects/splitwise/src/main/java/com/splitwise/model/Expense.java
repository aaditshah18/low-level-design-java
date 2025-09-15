package com.splitwise.model;

import java.util.List;
import com.splitwise.util.IdGenerator;

public abstract class Expense {
    private final String Id;
    private final double amount;
    private final User paidBy;
    private final List<Split> splits;
    private final String description;

    public Expense(double amount, User paidBy, List<Split> splits, String description) {
        this.Id = IdGenerator.generateId();
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.description = description;
    }

    public String getId() {return this.Id;}
    public double getAmount() {return this.amount;}
    public User getPaidBy() {return this.paidBy;}
    public List<Split> getSplits() {return this.splits;}
    public String getDescription() {return this.description;}

    public abstract boolean validate();
}