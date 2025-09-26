package com.notificationsystem.observer;

import com.notificationsystem.model.Notification;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Notification notification);
}