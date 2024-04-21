package com.example.reminder.controller;

import com.example.reminder.model.ReminderDto;
import com.example.reminder.service.ReminderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("http://domain/api/v1/reminder/")
@RequiredArgsConstructor
public class ReminderController {
    private final ReminderService reminderService;

    @PostMapping("/create")
    public ResponseEntity<ReminderDto> addReminder(@RequestBody ReminderDto addDto) {
        return ResponseEntity.ok(reminderService.addReminder(addDto));
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<Long> deleteReminderById(@PathVariable Long id) {
        reminderService.deleteReminderById(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReminderDto> updateReminderById(@PathVariable Long id, @RequestBody ReminderDto updateDto) {
        return ResponseEntity.ok(reminderService.updateReminderById(id, updateDto));
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<ReminderDto>> getRemindersByName(String name) {
        return ResponseEntity.ok(reminderService.findRemindersByName(name));
    }

    @GetMapping("/{description}")
    public ResponseEntity<List<ReminderDto>> getRemindersByDescription(String description) {
        return ResponseEntity.ok(reminderService.findRemindersByDescription(description));
    }

    @GetMapping("/{date}")
    public ResponseEntity<List<ReminderDto>> getRemindersByDate(Date date) {
        return ResponseEntity.ok(reminderService.findRemindersByDate(date));
    }

    @GetMapping("/{time}")
    public ResponseEntity<List<ReminderDto>> getRemindersByTime(Time time) {
        return ResponseEntity.ok(reminderService.findRemindersByTime(time));
    }
}