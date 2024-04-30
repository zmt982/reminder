package com.example.reminder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column
    private String email;
    @Column
    private String telegram;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reminder", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private Set<Reminder> reminders;
}