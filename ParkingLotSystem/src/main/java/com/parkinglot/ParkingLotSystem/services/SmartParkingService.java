package com.parkinglot.ParkingLotSystem.services;

import com.parkinglot.ParkingLotSystem.entity.ParkingSpot;
import com.parkinglot.ParkingLotSystem.entity.ParkingTransaction;
import com.parkinglot.ParkingLotSystem.entity.Vehicle;
import com.parkinglot.ParkingLotSystem.entity.VehicleType;
import com.parkinglot.ParkingLotSystem.repository.ParkingSpotRepository;
import com.parkinglot.ParkingLotSystem.repository.ParkingTransactionRepository;
import com.parkinglot.ParkingLotSystem.repository.VehicleRepository;
import com.parkinglot.ParkingLotSystem.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class SmartParkingService {
    @Autowired
    VehicleTypeRepository vehicleTypeRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    ParkingSpotRepository parkingSpotRepository;
    @Autowired
    ParkingTransactionRepository parkingTransactionRepository;

    private  Map<String, Double> ratePerHour = Map.of(
            "Motorcycle", 10.0,
            "Car", 20.0,
            "Bus", 30.0
    );

    public SmartParkingService(VehicleTypeRepository vehicleTypeRepository, VehicleRepository vehicleRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
        this.vehicleRepository = vehicleRepository;
    }
//    public VehicleType CreateVehicleType(VehicleType vehicleType) {
//        return vehicleTypeRepository.save(vehicleType);
//    }
//
//    public List<VehicleType> getAllVehicleTypes() {
//       return vehicleTypeRepository.findAll();
//    }
//
//    public ResponseEntity<?> CreateVehicle(String licenceNoPlate, Long typeId) {
//        VehicleType type = vehicleTypeRepository.findById(typeId).orElseThrow(() -> new RuntimeException("Vehicle type not found"));
//        Vehicle vehicle = new Vehicle();
//        vehicle.setLicenceNoPlate(licenceNoPlate);
//        vehicle.setType(type);
//       return ResponseEntity.ok(vehicleRepository.save(vehicle));
//    }
//
//    public List<Vehicle> getAllVehicles() {
//        return vehicleRepository.findAll();
//    }

    public List<ParkingSpot> getAllVehicleEntry(){
        return parkingSpotRepository.findAll();
    }

    public ParkingSpot vehicleEntry(String licenceNoPlate, String vehicleType) {

        VehicleType vehicleTyp = vehicleTypeRepository.findByType(vehicleType);
        Vehicle vehicle = new Vehicle();
        vehicle.setLicenceNoPlate(licenceNoPlate);
        vehicle.setType(vehicleTyp);
        vehicleRepository.save(vehicle);
        ParkingSpot spot = parkingSpotRepository.findBySize(vehicleTyp.getSize()).stream().findFirst().orElseThrow(()->new RuntimeException("No Available spots"));
        spot.setAvailabel(false);
        parkingSpotRepository.save(spot);
        ParkingTransaction pt = new ParkingTransaction();
        pt.setVehicle(vehicle);
        pt.setSpot(spot);
        pt.setEntryTime(LocalDateTime.now());
        parkingTransactionRepository.save(pt);
        return spot;
    }

    public double vehicleExit(String licenceNoPlate) {
        Vehicle vehicle = vehicleRepository.findByLicensePlate(licenceNoPlate);
        ParkingTransaction tx = parkingTransactionRepository.findByVehicleAndExitTimeIsNull(vehicle);

        tx.setExitTime(LocalDateTime.now());
        Duration duration = Duration.between(tx.getEntryTime(), tx.getExitTime());
        long hours = Math.max(1, duration.toHours());
        double rate = ratePerHour.get(vehicle.getType().getType());
        double fee = hours * rate;
        tx.setFee(fee);
        parkingTransactionRepository.save(tx);

        ParkingSpot spot = tx.getSpot();
        spot.setAvailabel(true);
        parkingSpotRepository.save(spot);

        return fee;
    }
}
