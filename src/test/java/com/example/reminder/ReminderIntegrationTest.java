package com.example.reminder;

import com.example.reminder.model.dto.ReminderDto;
import com.example.reminder.model.dto.UserDto;
import com.example.reminder.model.mapper.ReminderMapper;
import com.example.reminder.model.mapper.UserMapper;
import com.example.reminder.repository.ReminderRepository;
import com.example.reminder.repository.UserRepository;
import com.example.reminder.service.ReminderService;
import com.example.reminder.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReminderIntegrationTest {
    @Mock
    private static UserService userService;
    @Mock
    private static ReminderService reminderService;
    @InjectMocks
    private static UserRepository userRepository;
    @InjectMocks
    private static ReminderRepository reminderRepository;
    @InjectMocks
    private static UserMapper userMapper;
    @InjectMocks
    private static ReminderMapper reminderMapper;

    @BeforeAll
    public static void beforeAll() {
        userService = new UserService(userRepository, userMapper, reminderMapper);
        reminderService = new ReminderService(reminderRepository, reminderMapper);
    }

    @Test
    void reminderIntegrationTest() {
        UserDto userToAdd = new UserDto();
        userToAdd.setUsername("User to add");
        userToAdd.setEmail("test@gmail.com");
        userToAdd.setTelegram("@testTelegram");
        UserDto addedUser = userService.addUser(userToAdd);
        assertEquals(userToAdd, addedUser);

        List<UserDto> users = userService.getAll();
        assertEquals(Collections.singletonList(userToAdd), users);

        UserDto userGetById = userService.getById(1L);
        assertEquals(userToAdd, userGetById);

        UserDto userUpdateById = userService.updateById(1L, userToAdd);
        assertEquals(userToAdd, userUpdateById);

        userService.deleteUserById(1L);

        ReminderDto reminderToAdd = new ReminderDto();
        reminderToAdd.setTitle("titleTest");
        reminderToAdd.setDescription("descriptionTest");
        reminderToAdd.setRemind(LocalDateTime.of(2024, Month.MAY, 9, 00, 00));
        ReminderDto addedReminder = reminderService.addReminder(reminderToAdd);
        assertEquals(reminderToAdd, addedReminder);

        Pageable pageable = PageRequest.of(0, 4);
        Page<ReminderDto> remindersByName = reminderService.getRemindersByName(addedReminder.getTitle(), pageable);
        assertEquals((Page<ReminderDto>) Collections.singletonList(reminderToAdd), remindersByName);

        Page<ReminderDto> remindersByDescription = reminderService.getRemindersByDescription(addedReminder
                .getDescription(), pageable);
        assertEquals((Page<ReminderDto>) Collections.singletonList(reminderToAdd), remindersByDescription);

        Page<ReminderDto> remindersByDate = reminderService.getRemindersByDate(Date.from(addedReminder.getRemind()
                .atZone(ZoneId.systemDefault()).toInstant()), pageable);
        assertEquals((Page<ReminderDto>) Collections.singletonList(reminderToAdd), remindersByDate);

        Page<ReminderDto> remindersByTime = reminderService.getRemindersByTime(addedReminder.getRemind()
                .toLocalTime(), pageable);
        assertEquals((Page<ReminderDto>) Collections.singletonList(reminderToAdd), remindersByTime);

        Page<ReminderDto> remindersSortedByTitle = reminderService.getRemindersSortedByTitle(pageable);
        assertEquals((Page<ReminderDto>) Collections.singletonList(reminderToAdd), remindersSortedByTitle);

        Page<ReminderDto> remindersSortedByRemind = reminderService.getRemindersSortedByRemind(pageable);
        assertEquals((Page<ReminderDto>) Collections.singletonList(reminderToAdd), remindersSortedByRemind);

        Page<ReminderDto> remindersByTitleContaining = reminderService.getRemindersByTitleContaining(addedReminder
                .getTitle(), pageable);
        assertEquals((Page<ReminderDto>) Collections.singletonList(reminderToAdd), remindersByTitleContaining);

        ReminderDto reminderUpdateById = reminderService.updateReminderById(1L, reminderToAdd);
        assertEquals(reminderToAdd, reminderUpdateById);

        reminderService.deleteReminderById(1L);
    }
}