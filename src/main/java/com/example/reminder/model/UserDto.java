package com.example.reminder.model;

import com.example.reminder.entity.Reminder;

import java.util.Objects;

public class UserDto {
    private String username;
    private String email;
    private String telegram;
    private Reminder reminder;

    public UserDto() {
    }

    public UserDto(String username, String email, String telegram, Reminder reminder) {
        this.username = username;
        this.email = email;
        this.telegram = telegram;
        this.reminder = reminder;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(username, userDto.username) && Objects.equals(email, userDto.email) && Objects.equals(telegram, userDto.telegram) && Objects.equals(reminder, userDto.reminder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, telegram, reminder);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", telegram='" + telegram + '\'' +
                ", reminder=" + reminder +
                '}';
    }
}