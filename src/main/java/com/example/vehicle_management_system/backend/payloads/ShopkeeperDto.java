package com.example.vehicle_management_system.backend.payloads;

import lombok.Data;

@Data
public class ShopkeeperDto {

    private String shopName;
    private String shopkeeperName;
    private String shopAddress;
    private String shopCity;
    private String shopState;
    private String phoneNumber;
    private String email;
    private String password;
}
