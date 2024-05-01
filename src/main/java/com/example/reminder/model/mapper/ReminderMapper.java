package com.example.reminder.model.mapper;

import com.example.reminder.model.Reminder;
import com.example.reminder.model.User;
import com.example.reminder.model.dto.ReminderDto;
import com.example.reminder.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

//@Mapper(componentModel = "spring")
//public interface ReminderMapper {
////    @Mapping(source = "user.id", target = "userId")
//    ReminderDto toDto(Reminder reminder);
//
////    @Mapping(source = "userId", target = "user.id")
//    Reminder toEntity(ReminderDto dto);
//
//    List<ReminderDto> toDto(List<Reminder> reminders);
//
//    default Page<ReminderDto> toDto(Page<Reminder> reminders) {
//        return reminders.map(this::toDto);
//    }
//
//    Set<Reminder> toEntity(Set<ReminderDto> reminders);
//
//    default Page<Reminder> toEntity(Page<ReminderDto> reminders) {
//        return reminders.map(this::toEntity);
//    }
//}

public class ReminderMapper {
    private final UserRepository userRepository;

    public ReminderMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ReminderDto toDto(Reminder entity) {
        ReminderDto reminderDto = new ReminderDto();
        reminderDto.setId(entity.getId());
        reminderDto.setTitle(entity.getTitle());
        reminderDto.setDescription(entity.getDescription());
        reminderDto.setRemind(entity.getRemind());
        reminderDto.setUserId(entity.getUser().getId());
        return reminderDto;
    }

    public Reminder toEntity(ReminderDto dto) {
        Reminder entity = new Reminder();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setRemind(dto.getRemind());
        Optional<User> optionalUser = userRepository.findById(dto.getUserId());
        User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));
        entity.setUser(user);
        return entity;
    }

    public List<ReminderDto> toDto(List<Reminder> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<ReminderDto> toDto(Page<Reminder> entities) {
        Pageable pageable = PageRequest.of(entities.getNumber(), entities.getSize(), entities.getSort());
        List<ReminderDto> dtoList = entities.stream().map(this::toDto).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, entities.getTotalElements());
    }

    public Set<ReminderDto> toDto(Set<Reminder> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toSet());
    }

    public Set<Reminder> toEntity(Set<ReminderDto> dtoSet) {
        return dtoSet.stream().map(this::toEntity).collect(Collectors.toSet());
    }

    public Page<Reminder> toEntity(Page<ReminderDto> dtoPage) {
        Pageable pageable = PageRequest.of(dtoPage.getNumber(), dtoPage.getSize(), dtoPage.getSort());
        List<Reminder> entities = dtoPage.stream().map(this::toEntity).collect(Collectors.toList());
        return new PageImpl(entities, pageable, dtoPage.getTotalElements());
    }
}