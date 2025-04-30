package com.parkinglot.ParkingLotSystem.repository;

import com.parkinglot.ParkingLotSystem.entity.ParkingTransaction;
import com.parkinglot.ParkingLotSystem.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingTransactionRepository extends JpaRepository<ParkingTransaction,Long> {
    ParkingTransaction findByVehicleAndExitTimeIsNull(Vehicle vehicle);
}
