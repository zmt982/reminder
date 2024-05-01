package com.example.reminder.service;

import com.example.reminder.exception.ReminderNotFoundException;
import com.example.reminder.model.Reminder;
import com.example.reminder.model.dto.ReminderDto;
import com.example.reminder.model.mapper.ReminderMapper;
import com.example.reminder.repository.ReminderRepository;
import com.example.reminder.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReminderService {
    private final ReminderRepository reminderRepository;
    private final ReminderMapper reminderMapper;
    private final UserRepository userRepository;

    public ReminderDto addReminder(ReminderDto addDto) {
        Reminder reminderToAdd = reminderMapper.toEntity(addDto);
        reminderToAdd = reminderRepository.save(reminderToAdd);
        return reminderMapper.toDto(reminderToAdd);
    }

    public void deleteReminderById(Long id) {
        reminderRepository.deleteById(id);
    }

    public ReminderDto updateReminderById(Long id, ReminderDto updateDto) {
        Optional<Reminder> reminderToFind = reminderRepository.findById(id);
        Reminder reminderToUpdate = reminderToFind.orElseThrow(() -> new RuntimeException("No reminder found"));
        reminderToUpdate.setTitle(updateDto.getTitle());
        reminderToUpdate.setDescription(updateDto.getDescription());
        reminderToUpdate.setRemind(updateDto.getRemind());
        reminderToUpdate.setUser(userRepository.findById(updateDto.getUserId()).orElseThrow(() ->
                new RuntimeException("User not found")));
        return reminderMapper.toDto(reminderToUpdate);
    }

    public Page<ReminderDto> getRemindersByName(String name, Pageable pageable) {
        Optional<Page<Reminder>> optionalRemindersAllByName = Optional.ofNullable(reminderRepository
                .findRemindersByName(name, pageable));
        Page<Reminder> remindersAllByName = optionalRemindersAllByName.orElseThrow(() ->
                new RuntimeException("No reminders found by name"));
        return reminderMapper.toDto(remindersAllByName);
    }

    public Page<ReminderDto> getRemindersByDescription(String description, Pageable pageable) {
        Optional<Page<Reminder>> optionalRemindersAllByDescription = Optional.ofNullable(reminderRepository
                .findRemindersByDescription(description, pageable));
        Page<Reminder> remindersAllByDescription = optionalRemindersAllByDescription.orElseThrow(() ->
                new RuntimeException("No reminders found by description"));
        return reminderMapper.toDto(remindersAllByDescription);
    }

    public Page<ReminderDto> getRemindersByDate(Date date, Pageable pageable) {
        Optional<Page<Reminder>> optionalRemindersAllByDate = Optional.ofNullable(reminderRepository
                .findRemindersByDate(date, pageable));
        Page<Reminder> remindersAllByDate = optionalRemindersAllByDate.orElseThrow(() ->
                new RuntimeException("No reminders found by date"));
        return reminderMapper.toDto(remindersAllByDate);
    }

    public Page<ReminderDto> getRemindersByTime(LocalTime time, Pageable pageable) {
        Optional<Page<Reminder>> optionalRemindersAllByTime = Optional.ofNullable(reminderRepository
                .findRemindersByTime(time, pageable));
        Page<Reminder> remindersAllByTime = optionalRemindersAllByTime.orElseThrow(() ->
                new RuntimeException("No reminders found by time"));
        return reminderMapper.toDto(remindersAllByTime);
    }

    public Page<ReminderDto> getRemindersSortedByTitle(Pageable pageable) {
        Page<Reminder> remindersSortedByTitle = reminderRepository.findRemindersSortedByTitle(pageable);
        if (!remindersSortedByTitle.hasContent()) {
            throw new ReminderNotFoundException("Reminders not found");
        }
        return reminderMapper.toDto(remindersSortedByTitle);
    }

    public Page<ReminderDto> getRemindersSortedByRemind(Pageable pageable) {
        Page<Reminder> remindersSortedByRemind = reminderRepository.findRemindersSortedByRemind(pageable);
        if (!remindersSortedByRemind.hasContent()) {
            throw new ReminderNotFoundException("Reminders not found");
        }
        return reminderMapper.toDto(remindersSortedByRemind);
    }

    public Page<ReminderDto> getRemindersByTitleContaining(String title, Pageable pageable) {
        Page<Reminder> remindersByTitleContaining = reminderRepository.findRemindersByTitleContaining(title, pageable);
        if (!remindersByTitleContaining.hasContent()) {
            throw new ReminderNotFoundException("Reminders not found");
        }
        return reminderMapper.toDto(remindersByTitleContaining);
    }
}