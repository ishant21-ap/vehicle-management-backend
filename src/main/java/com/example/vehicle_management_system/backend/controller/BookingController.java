package com.example.vehicle_management_system.backend.controller;

import com.example.vehicle_management_system.backend.entity.BookingStatus;
import com.example.vehicle_management_system.backend.payloads.BookingDto;
import com.example.vehicle_management_system.backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    //Getting users booking history
    @GetMapping("/my")
    public List<BookingDto> getUserBookings(@RequestParam Long userId) {
        return bookingService.getUserBookings(userId);
    }

    //Getting Pending Booking for shopkeeper
    @GetMapping("/pending")
    public List<BookingDto> getPendingBookings(@RequestParam Long shopkeeperId) {
        return bookingService.getPendingBookingsForShopkeeper(shopkeeperId);
    }


    //Updating booking status (Coinfirm/Reject)
    @PutMapping("/{bookingId}/status")
    public BookingDto updateBookingStatus(@PathVariable Long bookingId,
                                          @RequestParam BookingStatus status,
                                          @RequestParam Long shopkeeperId) {
        return bookingService.updateBookingStatus(bookingId, status, shopkeeperId);
    }


    @PutMapping("/{bookingId}/complete")
    public BookingDto completeBooking(@PathVariable Long bookingId
    ,@RequestParam Long shopkeeperId) {
        return bookingService.completeBooking(bookingId, shopkeeperId);
    }


}