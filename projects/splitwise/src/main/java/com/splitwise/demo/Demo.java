package com.splitwise.demo;

import com.splitwise.enums.ExpenseType;
import com.splitwise.manager.ExpenseManager;
import com.splitwise.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class provides a sample execution of the Splitwise system by
 * creating users, forming a group, adding different types of expenses
 * (equal, exact, and percent), and displaying the resulting balances.
 * It serves as an entry point to showcase how the ExpenseManager and
 * related models work together in a real-world scenario.
 */
public class Demo {
    public static void demo() {
        ExpenseManager manager = new ExpenseManager();

        // Part 1 - Create new users and register them in memory
        User user1 = new User("dswami@testing.com", "991111999", "Dswami");
        manager.addUser(user1);

        User user2 = new User("aadit@testing.com", "992111999", "Aadit");
        manager.addUser(user2);

        User user3 = new User("dhrumi@testing.com", "993111999", "Dhrumi");
        manager.addUser(user3);

        User user4 = new User("malhar@testing.com", "994111999", "Malhar");
        manager.addUser(user4);

        // Part 2 - Create new groups and register that group in memory

        Group group = new Group("10B House Group");

        // Part 3 - Add users to the group

        group.addMember(user1);
        group.addMember(user2);
        group.addMember(user3);
        group.addMember(user4);

        manager.addGroup(group);

        // 1. Create equal expense
        List<Split> split1 = new ArrayList<>();
        split1.add(new EqualSplit(user1));
        split1.add(new EqualSplit(user4));

        manager.addExpense(ExpenseType.EQUAL, 100.00, user1, split1, "Tacos de Al Pastor", group);

        // 2. Create exact expense
        List<Split> split2 = new ArrayList<>();
        split2.add(new ExactSplit(user2, 60.00));
        split2.add(new ExactSplit(user3, 40.00));
        manager.addExpense(ExpenseType.EXACT, 100.00, user2, split2, "Burger and chips", group);

        // 3. Create percentage expense
        List<Split> split3 = new ArrayList<>();
        split3.add(new PercentSplit(user1, 20.00));
        split3.add(new PercentSplit(user2, 60.00));
        split3.add(new PercentSplit(user3, 20.00));
        manager.addExpense(ExpenseType.PERCENTAGE, 120.00, user4, split3, "Salad and pasta", group);

        manager.getBalances();

    }
}
