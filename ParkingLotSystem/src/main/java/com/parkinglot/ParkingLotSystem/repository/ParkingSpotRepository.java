package com.parkinglot.ParkingLotSystem.repository;

import com.parkinglot.ParkingLotSystem.entity.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot,Long> {
    List<ParkingSpot> findBySize(int size);
}
