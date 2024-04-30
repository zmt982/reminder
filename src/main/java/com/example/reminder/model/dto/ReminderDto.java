package com.example.reminder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Set;

@Data
//@AllArgsConstructor
public class ReminderDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime remind;
    private Long userId;
}