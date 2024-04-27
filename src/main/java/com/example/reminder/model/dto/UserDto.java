package com.example.reminder.model.dto;

import com.example.reminder.model.Reminder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String telegram;
    private Set<ReminderDto> reminders;
}