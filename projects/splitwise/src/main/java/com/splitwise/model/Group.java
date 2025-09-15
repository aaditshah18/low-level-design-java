package com.splitwise.model;

import java.util.ArrayList;
import java.util.List;
import com.splitwise.util.IdGenerator;

public class Group {
    private final String Id;
    private final String name;
    private final List<User> members;
    private final List<Expense> expenses;

    public Group(String name) {
        this.Id = IdGenerator.generateId();
        this.name = name;
        this.members = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public String getId() {return this.Id;}
    public String getName() {return this.name;}
    public List<User> getMembers() {return this.members;}
    public List<Expense> getExpenses() {return this.expenses;}

    public void addMember(User user) {
        this.members.add(user);
    }

    public void addExpense(Expense expense) {
        this.expenses.add(expense);
    }
}