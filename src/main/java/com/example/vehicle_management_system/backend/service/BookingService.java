package com.example.vehicle_management_system.backend.service;

import com.example.vehicle_management_system.backend.entity.BookingStatus;
import com.example.vehicle_management_system.backend.payloads.BookingDto;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    BookingDto createBooking(Long userId, Long vehicleId, LocalDate startDate, LocalDate endDate);
    List<BookingDto> getUserBookings(Long userId);
    List<BookingDto> getPendingBookingsForShopkeeper(Long shopkeeperId);
    BookingDto updateBookingStatus(Long bookingId, BookingStatus status, Long shopkeeperId);
    BookingDto completeBooking(Long bookingId, Long shopkeeperId);

}
