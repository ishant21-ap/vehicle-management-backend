package com.example.vehicle_management_system.backend.controller;

import com.example.vehicle_management_system.backend.entity.Shopkeeper;
import com.example.vehicle_management_system.backend.payloads.ShopkeeperDto;
import com.example.vehicle_management_system.backend.service.ShopkeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shopkeepers")
public class ShopkeeperController {

    @Autowired
    private ShopkeeperService shopkeeperService;


    @PostMapping("/register")
    public ResponseEntity<String> registerShopkeeper(@RequestBody ShopkeeperDto shopkeeperDto) {
        shopkeeperService.registerShopkeeper(shopkeeperDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Shopkeeper Registered Successfully !!");
    }


//    @PostMapping("/verifyOtp")
//    public ResponseEntity<String> verifyOtp(@RequestParam String email, @RequestParam String otp) {
//        boolean otpVerified = shopkeeperService.verfiyOtp(email, otp);
//        if (otpVerified) {
//            return ResponseEntity.ok("OTP Verified Successfully !!!");
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP or OTP expired !!");
//        }
//    }
}
