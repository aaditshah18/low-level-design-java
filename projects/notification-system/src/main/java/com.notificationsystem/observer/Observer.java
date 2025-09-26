package com.notificationsystem.observer;

import com.notificationsystem.model.Notification;

public interface Observer {
    void update(Notification notification);
}