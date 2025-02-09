package com.example.vehicle_management_system.backend.service;

import com.example.vehicle_management_system.backend.payloads.ShopkeeperDto;
import org.springframework.stereotype.Service;

@Service
public interface ShopkeeperService {

    ShopkeeperDto registerShopkeeper(ShopkeeperDto shopkeeperDto);
//    boolean verfiyOtp(String email, String otp);
}
