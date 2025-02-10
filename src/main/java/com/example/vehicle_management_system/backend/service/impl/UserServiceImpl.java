package com.example.vehicle_management_system.backend.service.impl;

import com.example.vehicle_management_system.backend.entity.Role;
import com.example.vehicle_management_system.backend.entity.Status;
import com.example.vehicle_management_system.backend.entity.User;
import com.example.vehicle_management_system.backend.payloads.UserDto;
import com.example.vehicle_management_system.backend.repository.UserRepository;
import com.example.vehicle_management_system.backend.service.OtpService;
import com.example.vehicle_management_system.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OtpService otpService;


    @Override
    public String registerUser(UserDto userDto) {

        if(userRepository.existsByEmail(userDto.getEmail())){
            return "Email already in use !";
        }

        User user = modelMapper.map(userDto, User.class);
        user.setRole(Role.valueOf(userDto.getRole()));
        user.setStatus(Status.INACTIVE);
        user.setLocked(false);
        user.setVerified(false);

        if(Role.SHOPKEEPER.name().equals(userDto.getRole())){
            user.setShopName(userDto.getShopName());
            user.setGstNumber(userDto.getGstNumber());
        }
        user.setLastLogin(LocalDateTime.now());
        userRepository.save(user);
        otpService.generateOtp(userDto.getEmail());
        return "Registration Successful. OTP sent to you email!";
    }


    @Override
    public UserDto getUserByEmail(String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        return modelMapper.map(user, UserDto.class);
    }



    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        return null;
    }

    @Override
    public boolean verfiyOtp(String email, String otp) {
        boolean isOtpValid = otpService.validateOtp(email, otp);

        if(isOtpValid){
            User user = userRepository.findByEmail(email).orElse(null);
            if(user != null){
                user.setStatus(Status.ACTIVE);
                userRepository.save(user);
            }
            return true;
        }
        return false;
    }
}
