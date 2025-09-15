package com.splitwise.model;

public abstract class Split{
    private final User user;
    private double amount;
    // A split contains user and the amount that user owes

    public Split(User user) {
        this.user = user;
    }

    public User getUser() {return this.user;}
    public double getAmount() {return this.amount;}

    public void setAmount(double amount) {this.amount = amount;}
}