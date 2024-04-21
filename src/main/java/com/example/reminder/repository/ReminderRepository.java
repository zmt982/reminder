package com.example.reminder.repository;

import com.example.reminder.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    List<Reminder> findAllByName(String name);

    List<Reminder> findAllByDescription(String description);

    List<Reminder> findAllByDate(Date date);

    List<Reminder> findAllByTime(Time time);
}
