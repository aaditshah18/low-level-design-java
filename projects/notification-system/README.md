# 🏥 Patient Monitoring & Notification System

This project is a Java-based patient monitoring system designed to demonstrate key software design principles and patterns. It simulates a real-world healthcare scenario where patient vital signs are continuously monitored, anomalies are detected, and notifications are instantly sent to healthcare professionals through various channels.

---

## ✨ Core Concepts

The system is built around the following core ideas:

*   🩺 **Patient Monitoring:** Continuously tracks patients' vital signs, including heart rate, blood pressure, oxygen saturation, and temperature.
*   🔬 **Anomaly Detection:** Uses a flexible set of rules to identify and flag abnormal vital sign readings that require attention.
*   🚀 **Notification System:** When an anomaly is detected, the system dispatches alerts to the relevant healthcare staff (doctors, nurses) through multiple channels like SMS, Email, and Push Notifications.
*   👥 **User Roles:** Defines distinct user roles (`Doctor`, `Nurse`) with different responsibilities and notification preferences.
*   🧩 **Extensibility:** Architected to be easily extended with new vital sign checks, notification channels, and user roles without altering existing code.

---

## 🎨 Design & Architecture

<details>
<summary>Click to view UML Diagram</summary>

```mermaid
classDiagram
    class User {
        -String id
        -String name
        -Role role
    }

    class Doctor {
        +User user
    }

    class Nurse {
        +User user
    }

    class Patient {
        -String id
        -String name
    }

    class VitalSignMonitor {
        -VitalCheckStrategy strategy
        +evaluate(VitalSignReading)
    }

    class VitalCheckStrategy {
        +evaluate(VitalSignReading)
    }

    class HeartRateCheck {
        +evaluate(VitalSignReading)
    }

    class TemperatureCheck {
        +evaluate(VitalSignReading)
    }
    
    class BloodPressureCheck {
        +evaluate(VitalSignReading)
    }
    
    class OxygenSaturationCheck {
        +evaluate(VitalSignReading)
    }

    class NotificationService {
        -channels : List~NotificationChannel~
        +sendNotification(Notification, User)
    }

    class NotificationChannel {
        +sendNotification(Notification, User)
    }

    class SMSChannel {
        +sendNotification(Notification, User)
    }

    class EmailChannel {
        +sendNotification(Notification, User)
    }
    
    class PushChannel {
        +sendNotification(Notification, User)
    }

    class PatientMonitorSubject {
        -observers : List~Observer~
        +registerObserver(Observer)
        +removeObserver(Observer)
        +notifyObservers(Notification)
    }

    class Observer {
        +update(Notification)
    }

    User <|-- Doctor
    User <|-- Nurse
    
    VitalSignMonitor o-- VitalCheckStrategy
    VitalCheckStrategy <|.. HeartRateCheck
    VitalCheckStrategy <|.. TemperatureCheck
    VitalCheckStrategy <|.. BloodPressureCheck
    VitalCheckStrategy <|.. OxygenSaturationCheck

    NotificationService o-- NotificationChannel
    NotificationChannel <|.. SMSChannel
    NotificationChannel <|.. EmailChannel
    NotificationChannel <|.. PushChannel

    PatientMonitorSubject o-- Observer
    Observer <|.. Doctor
    Observer <|.. Nurse
```

</details>

### SOLID Principles

This project adheres to the SOLID principles to ensure a robust and maintainable codebase.

| Principle                               | Description                                                                                                                                                                                          |
| --------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 🎯 **Single Responsibility (SRP)**      | Each class has one job. `VitalSignMonitor` checks vitals, `NotificationService` sends alerts, and models like `User` just hold data.                                                                  |
| 🔌 **Open/Closed (OCP)**                | The system is **open for extension, but closed for modification**. New vital checks or notification channels can be added via strategy and factory patterns without changing the core logic.           |
| ↔️ **Liskov Substitution (LSP)**         | Subtypes can replace their base types without errors. A `Doctor` or `Nurse` can be used anywhere a `User` is expected.                                                                                |
| 🍴 **Interface Segregation (ISP)**      | We use small, focused interfaces (`NotificationChannel`, `VitalCheckStrategy`, `Observer`) instead of large, general-purpose ones.                                                                   |
| 🔄 **Dependency Inversion (DIP)**       | High-level modules depend on abstractions, not on low-level details. `VitalSignMonitor` depends on the `VitalCheckStrategy` interface, not a concrete `HeartRateCheck`.                               |

### Design Patterns

Several design patterns are employed to solve common architectural challenges elegantly.

| Pattern                               | Usage                                                                                                                                                                                                |
| ------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 🚗 **Strategy Pattern**               | Defines a family of algorithms (vital sign checks) and makes them interchangeable. This allows the checking logic for `HeartRateCheck` vs. `BloodPressureCheck` to be swapped at runtime.             |
| 🏭 **Factory Pattern**                | Creates objects without exposing the complex creation logic. `NotificationChannelFactory` and `VitalCheckStrategyFactory` abstract away the instantiation of different channels and check strategies. |
| 👀 **Observer Pattern**                | Establishes a one-to-many dependency. The `PatientMonitorSubject` (the subject) notifies all registered `Observer`s (e.g., doctors, nurses) when a patient's vital signs become abnormal.          |
| 🏭 **Static Factory**                 | The `VitalCheckStrategyFactory` uses a static block to pre-load strategies into a map. This ensures strategies are singletons, improving performance and memory efficiency.                           |

---

## 📂 Project Structure

The project is organized into packages to ensure a clean separation of concerns, making the system easier to navigate and extend.

-   `demo`: Contains a runnable demonstration of the system.
-   `enums`: Holds enumerations for `Role`, `SeverityLevel`, and `VitalType`.
-   `exceptions`: Contains custom exception classes for error handling.
-   `factory`: Home to factory classes for creating objects dynamically.
-   `manager`: Contains the core `NotificationService` for managing notifications.
-   `model`: Contains the data models (e.g., `User`, `Patient`, `Notification`).
-   `observer`: Contains the classes implementing the Observer design pattern.
-   `strategy`: Contains the Strategy pattern classes, organized into `channel` and `vital` sub-packages.
-   `util`: Contains utility classes like `AuditLogger` and `IdGenerator`.

---

## 🛠️ Setup and Usage

### Prerequisites

*   Java Development Kit (JDK) 11 or higher
*   Apache Maven

### Build and Run

1.  **Clone the repository** and navigate to the project directory:
    ```bash
    cd projects/notification-system
    ```

2.  **Build the project** using Maven:
    ```bash
    mvn clean install
    ```

3.  **Run the demo** to see the system in action:
    ```bash
    mvn exec:java -Dexec.mainClass="com.notificationsystem.Main"
    ```
    This will simulate monitoring a patient's vital signs and sending notifications to a doctor and a nurse.

---

## 🧩 How to Extend the System

### Adding a New Vital Sign Check

1.  **Create a Strategy:** Create a new class that implements the `VitalCheckStrategy` interface.
2.  **Implement Logic:** Add the evaluation logic in the `evaluate` method.
3.  **Register Type:** Add the new vital sign to the `VitalType` enum.
4.  **Update Factory:** Register the new strategy in the `VitalCheckStrategyFactory`.

### Adding a New Notification Channel

1.  **Create a Channel:** Create a new class that implements the `NotificationChannel` interface.
2.  **Implement Logic:** Add the sending logic in the `sendNotification` method.
3.  **Update Factory:** Register the new channel in the `NotificationChannelFactory`.
4.  **Register Channel:** Add the new channel to the `NotificationService` in the demo.
