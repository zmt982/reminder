package com.example.reminder.entity;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String telegram;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Reminder reminder;

    public User() {
    }

    public User(Long id, String username, String email, String telegram, Reminder reminder) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.telegram = telegram;
        this.reminder = reminder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) && Objects.equals(telegram, user.telegram) &&
                Objects.equals(reminder, user.reminder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, telegram, reminder);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", email='" + email + '\'' + ", telegram='"
                + telegram + '\'' + ", reminder=" + reminder + '}';
    }
}