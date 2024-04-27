package com.example.reminder.model;

import com.example.reminder.entity.Reminder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;
    private String email;
    private String telegram;
    private Reminder reminder;
}