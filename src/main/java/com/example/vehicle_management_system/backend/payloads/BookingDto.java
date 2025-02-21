package com.example.vehicle_management_system.backend.payloads;

import com.example.vehicle_management_system.backend.entity.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDto {

    private Long id;
    private Long userId;
    private Long vehicleId;
    private Long shopkeeperId;
    private BookingStatus status;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalPrice;

}
