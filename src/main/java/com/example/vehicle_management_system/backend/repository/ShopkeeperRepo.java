package com.example.vehicle_management_system.backend.repository;

import com.example.vehicle_management_system.backend.entity.Shopkeeper;
import com.example.vehicle_management_system.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopkeeperRepo extends JpaRepository<Shopkeeper, Long> {
    Optional<Shopkeeper> findByEmail(String email);


}
