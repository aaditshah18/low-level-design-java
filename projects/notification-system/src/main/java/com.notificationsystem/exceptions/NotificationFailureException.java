package com.notificationsystem.exceptions;

public class NotificationFailureException extends RuntimeException {
    public NotificationFailureException(String message) {
        super(message);
    }
}