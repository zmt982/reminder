package com.example.reminder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReminderDto {
    private String title;
    private String description;
    private DateFormat remind;
    private Set<UserDto> users;
}