package com.example.reminder.service;

import com.example.reminder.entity.User;
import com.example.reminder.model.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public UserDto toDto(User entity) {
        UserDto userDto = new UserDto();
        userDto.setUsername(entity.getUsername());
        userDto.setEmail(entity.getEmail());
        userDto.setTelegram(entity.getTelegram());
        userDto.setReminder(entity.getReminder());
        return userDto;
    }

    public User toEntity(UserDto userDto) {
        User entity = new User();
        entity.setUsername(userDto.getUsername());
        entity.setEmail(userDto.getEmail());
        entity.setTelegram(userDto.getTelegram());
        entity.setReminder(userDto.getReminder());
        return entity;
    }

    public List<UserDto> toDto(List<User> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<User> toEntity(List<UserDto> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}