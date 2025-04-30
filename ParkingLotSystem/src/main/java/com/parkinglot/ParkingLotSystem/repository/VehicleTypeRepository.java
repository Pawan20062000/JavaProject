package com.parkinglot.ParkingLotSystem.repository;

import com.parkinglot.ParkingLotSystem.entity.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType,Long> {
    VehicleType findByType(String vehicleType);
}
