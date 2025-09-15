package com.splitwise.model;

public class PercentSplit extends Split {
    private final double percent;
    public PercentSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }
    public double getPercent() {return this.percent;}
}