package com.example.reminder.repository;

import com.example.reminder.model.Reminder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;
import java.util.Date;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {

    Page<Reminder> findRemindersByName(String name, Pageable pageable);

    Page<Reminder> findRemindersByDescription(String description, Pageable pageable);

    Page<Reminder> findRemindersByDate(Date date, Pageable pageable);

    Page<Reminder> findRemindersByTime(LocalTime time, Pageable pageable);

    @Query("SELECT r FROM Reminder r ORDER BY r.title")
    Page<Reminder> findRemindersSortedByTitle(Pageable pageable);

    @Query("SELECT r FROM Reminder r ORDER BY r.remind")
    Page<Reminder> findRemindersSortedByRemind(Pageable pageable);

    @Query("SELECT r FROM Reminder r WHERE LOWER(r.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    Page<Reminder> findRemindersByTitleContaining(String title, Pageable pageable);
}