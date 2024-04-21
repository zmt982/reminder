package com.example.reminder.service;

import com.example.reminder.entity.User;
import com.example.reminder.model.UserDto;
import com.example.reminder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toDto(users);
    }

    public UserDto getById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        User userToFind = userOptional.orElseThrow(() -> new RuntimeException("No user found"));
        return userMapper.toDto(userToFind);
    }

    public UserDto addUser(UserDto addDto) {
        User userToAdd = userMapper.toEntity(addDto);
        userToAdd = userRepository.save(userToAdd);
        return userMapper.toDto(userToAdd);
    }

    public UserDto updateById(Long id, UserDto updateDto) {
        Optional<User> userToFind = userRepository.findById(id);
        User userToUpdate = userToFind.orElseThrow(() -> new RuntimeException("No user found"));
        userToUpdate.setUsername(updateDto.getUsername());
        userToUpdate.setEmail(updateDto.getEmail());
        userToUpdate.setTelegram(updateDto.getTelegram());
        userToUpdate.setReminder(updateDto.getReminder());
        return userMapper.toDto(userToUpdate);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}