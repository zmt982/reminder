package com.example.reminder.model.mapper;

import com.example.reminder.model.User;
import com.example.reminder.model.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    List<User> toEntity(List<UserDto> users);

    List<UserDto> toDto(List<User> users);
}