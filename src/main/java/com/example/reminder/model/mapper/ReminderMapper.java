package com.example.reminder.service;

import com.example.reminder.model.Reminder;
import com.example.reminder.model.dto.ReminderDto;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ReminderMapper {
    private final UserMapper userMapper;

    public ReminderDto toDto(Reminder entity) {
        ReminderDto reminderDto = new ReminderDto();
        reminderDto.setTitle(entity.getTitle());
        reminderDto.setDescription(entity.getDescription());
        reminderDto.setRemind(entity.getRemind());
        reminderDto.setUsers(entity.getUsers().stream().map(user -> userMapper.toDto(user)).collect(Collectors.toSet()));
        return reminderDto;
    }

    public Reminder toEntity(ReminderDto reminderDto) {
        Reminder entity = new Reminder();
        entity.setTitle(reminderDto.getTitle());
        entity.setDescription(reminderDto.getDescription());
        entity.setRemind(reminderDto.getRemind());
        entity.setUsers(reminderDto.getUsers().stream().map(userDto -> userMapper.toEntity(userDto))
                .collect(Collectors.toSet()));
        return entity;
    }

    public List<ReminderDto> toDto(List<Reminder> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<Reminder> toEntity(List<ReminderDto> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}