package com.example.vehicle_management_system.backend.service;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}
