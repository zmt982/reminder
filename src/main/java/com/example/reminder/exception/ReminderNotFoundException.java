package com.example.reminder.service;

public class ReminderNotFoundException extends RuntimeException {
    public ReminderNotFoundException(String message) {
        super(message);
    }
}