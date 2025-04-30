package com.parkinglot.ParkingLotSystem.controller;

import com.parkinglot.ParkingLotSystem.entity.Vehicle;
import com.parkinglot.ParkingLotSystem.entity.VehicleType;
import com.parkinglot.ParkingLotSystem.repository.VehicleRepository;
import com.parkinglot.ParkingLotSystem.repository.VehicleRepository;
import com.parkinglot.ParkingLotSystem.repository.VehicleTypeRepository;
import com.parkinglot.ParkingLotSystem.services.SmartParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    private SmartParkingService smartParkingService;


//    @PostMapping("/types")
//    public VehicleType CreateVehicleType(@RequestBody VehicleType vehicleType){
//        return smartParkingService.CreateVehicleType(vehicleType);
//    }
//
//    @GetMapping("/types")
//    public List<VehicleType> getAllVehicleTypes(){
//        return  smartParkingService.getAllVehicleTypes();
//    }
//
//    @PostMapping("/vehicles")
//    public ResponseEntity<?> CreateVehicle(@RequestParam String licenceNoPlate, @RequestParam Long typeId){
//        return smartParkingService.CreateVehicle(licenceNoPlate,typeId);
//    }
//
//    @GetMapping("/vehicles")
//    public List<Vehicle> getAllVehicles(){
//        return smartParkingService.getAllVehicles();
//    }
//    //    public ResponseEntity<?> createVehicle(@RequestParam String licensePlate, @RequestParam Long typeId) {
//        VehicleType type = vehicleTypeRepository.findById(typeId)
//                .orElseThrow(() -> new RuntimeException("Vehicle type not found"));
//
//        Vehicle vehicle = new Vehicle();
//        vehicle.setLicensePlate(licensePlate);
//        vehicle.setType(type);
//
//        return ResponseEntity.ok(vehicleRepository.save(vehicle));
//    }
}