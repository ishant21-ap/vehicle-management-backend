package com.example.vehicle_management_system.backend.service.impl;

import com.example.vehicle_management_system.backend.entity.Role;
import com.example.vehicle_management_system.backend.entity.Shopkeeper;
import com.example.vehicle_management_system.backend.entity.Status;
import com.example.vehicle_management_system.backend.payloads.ShopkeeperDto;
import com.example.vehicle_management_system.backend.repository.ShopkeeperRepo;
import com.example.vehicle_management_system.backend.service.OtpService;
import com.example.vehicle_management_system.backend.service.ShopkeeperService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopkeeperService {

    @Autowired
    private ShopkeeperRepo shopkeeperRepo;

    @Autowired
    private ModelMapper modelMapper;


//    @Autowired
//    private OtpService otpService;

    @Override
    public ShopkeeperDto registerShopkeeper(ShopkeeperDto shopkeeperDto) {
        Shopkeeper shopkeeper = modelMapper.map(shopkeeperDto, Shopkeeper.class);
        shopkeeper.setRole(Role.SHOPKEEPER);
        shopkeeper.setStatus(Status.INACTIVE);
        shopkeeperRepo.save(shopkeeper);

//        otpService.generateOtp(shopkeeperDto.getEmail());
        return modelMapper.map(shopkeeper, ShopkeeperDto.class);
    }


//    @Override
//    public boolean verfiyOtp(String email, String otp) {
//        boolean isVerified = otpService.validateOtp(email, otp);
//        if (isVerified) {
//            Shopkeeper shopkeeper = shopkeeperRepo.findByEmail(email).orElse(null);
//            if(shopkeeper != null) {
//                shopkeeper.setStatus(Status.ACTIVE);
//                shopkeeperRepo.save(shopkeeper);
//            }
//            return true;
//        }
//            return false;
//    }
}
