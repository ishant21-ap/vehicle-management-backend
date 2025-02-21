package com.example.vehicle_management_system.backend.controller;

import com.example.vehicle_management_system.backend.payloads.BookingDto;
import com.example.vehicle_management_system.backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin("*")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @PostMapping
    public ResponseEntity<BookingDto> createBooking(
            @RequestParam Long userId,
            @RequestParam Long vehicleId,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        BookingDto bookingDto = bookingService.createBooking(userId, vehicleId, LocalDate.parse(startDate), LocalDate.parse(endDate));
        return ResponseEntity.ok(bookingDto);
    }


}
