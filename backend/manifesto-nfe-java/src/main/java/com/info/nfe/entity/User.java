package com.info.nfe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_user_email", columnNames = "email")
        })
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @Column(nullable = false, length = 120)
        private String name;

        @Column(nullable = false, length = 255)
        private String email;

        @Column(nullable = false, length = 100)
        private String passwordHash;

        @CreationTimestamp
        @Column(nullable = false, updatable = false)
        private Instant createdAt;

        @UpdateTimestamp
        @Column(nullable = false)
        private Instant updatedAt;
}
