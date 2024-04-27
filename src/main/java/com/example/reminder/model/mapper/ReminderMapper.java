package com.example.reminder.model.mapper;

import com.example.reminder.model.Reminder;
import com.example.reminder.model.dto.ReminderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ReminderMapper {
    //    @Mapping(source = "user.id", target = "userId")
    ReminderDto toDto(Reminder reminder);

    List<ReminderDto> toDto(List<Reminder> reminders);

    Page<ReminderDto> toDto(Page<Reminder> reminders);

    //    @Mapping(source = "userId", target = "user.id")
    Reminder toEntity(ReminderDto dto);

    Set<Reminder> toEntity(Set<ReminderDto> reminders);

    Page<Reminder> toEntity(Page<ReminderDto> reminders);
}