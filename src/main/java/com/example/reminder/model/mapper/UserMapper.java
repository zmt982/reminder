package com.example.reminder.model.mapper;

import com.example.reminder.model.User;
import com.example.reminder.model.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

//@Mapper(componentModel = "spring")
//public interface UserMapper {
//    UserDto toDto(User user);
//
//    User toEntity(UserDto userDto);
//
//    List<UserDto> toDto(List<User> users);
//
//    List<User> toEntity(List<UserDto> users);
//}

public class UserMapper {
    ReminderMapper reminderMapper;

    public UserDto toDto(User entity) {
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setUsername(entity.getUsername());
        userDto.setEmail(entity.getEmail());
        userDto.setTelegram(entity.getTelegram());
        userDto.setReminders(reminderMapper.toDto(entity.getReminders()));
        return userDto;
    }

    public User toEntity(UserDto userDto) {
        User entity = new User();
        entity.setId(userDto.getId());
        entity.setUsername(userDto.getUsername());
        entity.setEmail(userDto.getEmail());
        entity.setTelegram(userDto.getTelegram());
        entity.setReminders(reminderMapper.toEntity(userDto.getReminders()));
        return entity;
    }

    public List<UserDto> toDto(List<User> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<User> toEntity(List<UserDto> users) {
        return users.stream().map(this::toEntity).collect(Collectors.toList());
    }
}