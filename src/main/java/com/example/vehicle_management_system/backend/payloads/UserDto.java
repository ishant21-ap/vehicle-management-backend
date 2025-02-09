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
}
