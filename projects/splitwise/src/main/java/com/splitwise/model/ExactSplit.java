package com.splitwise.model;

public class ExactSplit extends Split {
    private double amount;
    public ExactSplit(User user, double amount) {
        super(user);
        setAmount(amount);
    }
}