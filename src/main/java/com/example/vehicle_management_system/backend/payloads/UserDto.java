package com.example.vehicle_management_system.backend.payloads;

import lombok.Data;

@Data
public class UserDto {

    private String name;
    private String email;
    private String phone;
    private String password;
    private String address;
    private String role;

    // New common fields
    private String dob; // Keep it as a String for flexibility, convert to LocalDate in backend
    private String profileImageUrl;
    private String gender;

    // Only for shopkeeper
    private String shopName;
    private String gstNumber;
    private String shopAddress;
    private String businessType;
}
