package com.example.vehicle_management_system.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String phone;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

    // New common fields
    private LocalDate dob;
    private String profileImageUrl;
    private String gender;  // Example values: "Male", "Female", "Other"
    private LocalDateTime lastLogin;
    private boolean isLocked = false; // Default to false
    private boolean isVerified = false; // Default to false

    // Only for shopkeepers
    private String shopName;
    private String gstNumber;
    private String shopAddress;
    private String businessType; // Example values: "Retail", "Wholesale"

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String otp;
    private LocalDateTime otpExpirationTime;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
