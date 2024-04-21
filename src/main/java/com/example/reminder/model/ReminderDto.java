package com.example.reminder.model;

import java.text.DateFormat;
import java.util.Objects;
import java.util.Set;

public class ReminderDto {
    private String title;
    private String description;
    private DateFormat remind;
    private Set<UserDto> users;

    public ReminderDto() {
    }

    public ReminderDto(String title, String description, DateFormat remind, Set<UserDto> users) {
        this.title = title;
        this.description = description;
        this.remind = remind;
        this.users = users;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateFormat getRemind() {
        return remind;
    }

    public void setRemind(DateFormat remind) {
        this.remind = remind;
    }

    public Set<UserDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDto> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReminderDto that = (ReminderDto) o;
        return Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(remind, that.remind) && Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, remind, users);
    }

    @Override
    public String toString() {
        return "ReminferDto{" + "title='" + title + '\'' + ", description='" + description + '\'' + ", remind=" + remind + ", userDto=" + users + '}';
    }
}