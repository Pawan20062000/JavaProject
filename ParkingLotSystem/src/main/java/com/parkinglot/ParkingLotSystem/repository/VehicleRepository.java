package com.parkinglot.ParkingLotSystem.repository;

import com.parkinglot.ParkingLotSystem.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    Vehicle findByLicensePlate(String licenceNoPlate);
}
