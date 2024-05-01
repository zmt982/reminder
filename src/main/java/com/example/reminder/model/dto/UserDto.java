package com.example.reminder.model.dto;

import lombok.Data;

import java.util.Set;

@Data
//@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String telegram;
    private Set<ReminderDto> reminders;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getTelegram() {
//        return telegram;
//    }
//
//    public void setTelegram(String telegram) {
//        this.telegram = telegram;
//    }
//
//    public Set<ReminderDto> getReminders() {
//        return reminders;
//    }
//
//    public void setReminders(Set<ReminderDto> reminders) {
//        this.reminders = reminders;
//    }
}