package com.example.reminder.entity;

import com.example.reminder.model.UserDto;
import jakarta.persistence.*;

import java.text.DateFormat;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "reminders")
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private DateFormat remind;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reminder", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users;

    public Reminder() {
    }

    public Reminder(Long id, String title, String description, DateFormat remind, Set<User> users) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.remind = remind;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reminder reminder = (Reminder) o;
        return Objects.equals(id, reminder.id) && Objects.equals(title, reminder.title) &&
                Objects.equals(description, reminder.description) && Objects.equals(remind, reminder.remind) &&
                Objects.equals(users, reminder.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, remind, users);
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", remind=" + remind +
                ", users=" + users +
                '}';
    }
}