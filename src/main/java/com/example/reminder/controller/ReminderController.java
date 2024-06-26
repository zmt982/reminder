package com.example.reminder.controller;

import com.example.reminder.model.dto.ReminderDto;
import com.example.reminder.service.ReminderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;

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
    public ResponseEntity<Page<ReminderDto>> getRemindersByName(String name, Pageable pageable) {
        return ResponseEntity.ok(reminderService.findRemindersByName(name, pageable));
    }

    @GetMapping("/{description}")
    public ResponseEntity<Page<ReminderDto>> getRemindersByDescription(String description, Pageable pageable) {
        return ResponseEntity.ok(reminderService.findRemindersByDescription(description, pageable));
    }

    @GetMapping("/{date}")
    public ResponseEntity<Page<ReminderDto>> getRemindersByDate(Date date, Pageable pageable) {
        return ResponseEntity.ok(reminderService.findRemindersByDate(date, pageable));
    }

    @GetMapping("/{time}")
    public ResponseEntity<Page<ReminderDto>> getRemindersByTime(Time time, Pageable pageable) {
        return ResponseEntity.ok(reminderService.findRemindersByTime(time, pageable));
    }

    @GetMapping("/sorted-by-title")
    public ResponseEntity<Page<ReminderDto>> getRemindersSortedByTitle(Pageable pageable) {
        return ResponseEntity.ok(reminderService.findRemindersSortedByTitle(pageable));
    }

    @GetMapping("/sorted-by-remind")
    public ResponseEntity<Page<ReminderDto>> getRemindersSortedByRemind(Pageable pageable) {
        return ResponseEntity.ok(reminderService.findRemindersSortedByRemind(pageable));
    }

    @GetMapping("/sorted-by-title-contain")
    public ResponseEntity<Page<ReminderDto>> getRemindersByTitleContainig(String string, Pageable pageable) {
        return ResponseEntity.ok(reminderService.findRemindersByTitleContaining(string, pageable));
    }
}