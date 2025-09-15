# Splitwise Expense Sharing Application

## Overview

This project is a simplified command-line version of a Splitwise-like expense sharing application. It allows users to be created, grouped, and to add expenses with different split types (Equal, Exact, and Percentage). The application then calculates and displays the balances owed between users. This project serves as a practical example of applying core object-oriented design principles and design patterns in Java.

## Core Concepts

The application is built around a few core concepts that work together to model the expense sharing process:

*   **User:** Represents an individual who can participate in expenses. Each user has a unique ID, name, email, and mobile number.

*   **Group:** A collection of users who share expenses. A group has a name and a list of members. All expenses are recorded within a group.

*   **Expense:** This is the central entity in the system, representing a single financial transaction. An expense has an amount, the user who paid it, a description, and a list of splits that determine how the cost is divided. `Expense` is an abstract class, with concrete implementations for different ways of splitting the cost:
    *   `EqualExpense`: The cost is divided equally among all participants.
    *   `ExactExpense`: Each participant pays a specific, pre-defined amount.
    *   `PercentExpense`: Each participant pays a certain percentage of the total amount.

*   **Split:** This abstract class represents how a single user's share of an expense is calculated. There are concrete subclasses that correspond to the different expense types:
    *   `EqualSplit`: For `EqualExpense`.
    *   `ExactSplit`: For `ExactExpense`, storing the exact amount owed.
    *   `PercentSplit`: For `PercentExpense`, storing the percentage owed.

*   **ExpenseManager:** This class acts as the main controller of the system. It manages users, groups, and the balance sheet. It provides the main logic for adding expenses and calculating the final balances between users.

## Design Patterns Used

This project demonstrates the use of several important design patterns that help to make the code more flexible, extensible, and maintainable.

### Factory Pattern

The **Factory Pattern** is used to create objects without exposing the creation logic to the client. In this project, the `ExpenseFactory` class is a clear example of this pattern.

*   **How it's used:** The `ExpenseManager` doesn't create `Expense` objects directly. Instead, it delegates this responsibility to the `ExpenseFactory`. Based on the `ExpenseType` enum (`EQUAL`, `EXACT`, or `PERCENTAGE`), the factory method `createExpense` returns the appropriate concrete `Expense` object (`EqualExpense`, `ExactExpense`, or `PercentExpense`).

*   **Benefits:** This decouples the `ExpenseManager` from the concrete `Expense` classes. If we want to add a new expense type in the future (e.g., `ShareExpense`), we would only need to create a new `ShareExpense` class and update the `ExpenseFactory`. The `ExpenseManager` would not need to be changed, adhering to the Open/Closed Principle.

## SOLID Principles

The design of this application adheres to the SOLID principles of object-oriented design, which make the system more robust and easier to maintain.

### Single Responsibility Principle (SRP)

Each class in the project has a single, well-defined responsibility.

*   `User`, `Group`, `Expense`, and `Split` classes are all model classes that only hold data and have no other responsibilities.
*   `ExpenseManager` is responsible for managing the high-level operations of the application.
*   `ExpenseFactory` is solely responsible for creating `Expense` objects.
*   `IdGenerator` has the single purpose of generating unique IDs.

### Open/Closed Principle (OCP)

The system is designed to be **open for extension, but closed for modification.**

*   This is most evident in the handling of expense types. If a new expense type is needed, we can create a new subclass of `Expense` and a corresponding `Split` class, and then update the `ExpenseFactory`. We do not need to modify the existing `ExpenseManager` or other core components of the system.

### Liskov Substitution Principle (LSP)

The different types of expenses (`EqualExpense`, `ExactExpense`, `PercentExpense`) are all subtypes of the `Expense` abstract class. They can be used interchangeably wherever an `Expense` object is expected.

*   For example, the `ExpenseManager`'s `addExpense` method works with an `Expense` object. Thanks to polymorphism, it can handle any of the concrete expense types without needing to know the specific type. Each expense type has its own `validate()` method, which is called polymorphically.

## Setup and Usage

This project is built using Apache Maven. You can build and run it from the command line.

### Prerequisites

*   Java Development Kit (JDK) 8 or higher
*   Apache Maven

### Building the Project

1.  Navigate to the `projects/splitwise` directory.
2.  Run the following Maven command to build the project:

    ```sh
    mvn clean install
    ```

### Running the Application

Once the project is built, you can run the application using the following command from the `projects/splitwise` directory:

```sh
mvn exec:java -Dexec.mainClass="com.splitwise.Main"
```

This will execute the `demo()` method in the `Demo` class, which showcases the application's functionality by creating users, adding various types of expenses, and printing the final balances.
