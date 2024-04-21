package com.example.reminder.service;

import com.example.reminder.entity.Reminder;
import com.example.reminder.model.ReminderDto;
import com.example.reminder.repository.ReminderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReminderService {
    private final ReminderRepository reminderRepository;
    private final ReminderMapper reminderMapper;
    private final UserMapper userMapper;

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
        Reminder reminderToUpdate = reminderToFind.orElseThrow(() -> new RuntimeException("No reminder to found"));
        reminderToUpdate.setTitle(updateDto.getTitle());
        reminderToUpdate.setDescription(updateDto.getDescription());
        reminderToUpdate.setRemind(updateDto.getRemind());
        reminderToUpdate.setUsers(updateDto.getUsers().stream().map(userDto -> userMapper.toEntity(userDto))
                .collect(Collectors.toSet()));
        return reminderMapper.toDto(reminderToUpdate);
    }

    public List<ReminderDto> findRemindersByName(String name) {
        Optional<List<Reminder>> optionalRemindersAllByName = Optional.ofNullable(reminderRepository.findAllByName(name));
        List<Reminder> remindersAllByName = optionalRemindersAllByName.orElseThrow(() ->
                new RuntimeException("No reminders found by name"));
        return reminderMapper.toDto(remindersAllByName);
    }

    public List<ReminderDto> findRemindersByDescription(String description) {
        Optional<List<Reminder>> optionalRemindersAllByDescription =
                Optional.ofNullable(reminderRepository.findAllByDescription(description));
        List<Reminder> remindersAllByDescription = optionalRemindersAllByDescription.orElseThrow(() ->
                new RuntimeException("No reminders found by description"));
        return reminderMapper.toDto(remindersAllByDescription);
    }

    public List<ReminderDto> findRemindersByDate(Date date) {
        Optional<List<Reminder>> optionalRemindersAllByDate = Optional.ofNullable(reminderRepository.findAllByDate(date));
        List<Reminder> remindersAllByDate = optionalRemindersAllByDate.orElseThrow(() ->
                new RuntimeException("No reminders found by date"));
        return reminderMapper.toDto(remindersAllByDate);
    }

    public List<ReminderDto> findRemindersByTime(Time time) {
        Optional<List<Reminder>> optionalRemindersAllByTime = Optional.ofNullable(reminderRepository.findAllByTime(time));
        List<Reminder> remindersAllByTime = optionalRemindersAllByTime.orElseThrow(() -> new RuntimeException("No found by time"));
        return reminderMapper.toDto(remindersAllByTime);
    }

//    public List<ReminderDto> SortingByName(String name)
//    public List<ReminderDto> SortingByDate
//    public List<ReminderDto> SortingByTime
//    public List<ReminderDto> FilterByDate
//    public List<ReminderDto> FilterByTime

}
