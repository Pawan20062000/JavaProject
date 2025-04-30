package com.parkinglot.ParkingLotSystem.controller;


import com.parkinglot.ParkingLotSystem.entity.ParkingSpot;
import com.parkinglot.ParkingLotSystem.services.SmartParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {
    @Autowired
    SmartParkingService smartParkingService;

    public ParkingController(SmartParkingService smartParkingService) {
        this.smartParkingService = smartParkingService;
    }

    @PostMapping("/vehicleEntry")
    public Map<String, Object> vehicleEntry(@RequestParam String licenceNoPlate,@RequestParam String vehicleType){
        ParkingSpot spot = smartParkingService.vehicleEntry(licenceNoPlate,vehicleType);
        return Map.of("spotAssigned",spot.getSpotNo(),"floor",spot.getFloor());
    }

    @GetMapping("/vehicleEntry")
    public List<ParkingSpot> getAllVehicleEntry(){
        return  smartParkingService.getAllVehicleEntry();
    }

    @PostMapping("/vehicleExit")
    public Map<String, Object> exit(@RequestParam String licenceNoPlate) {
        double fee = smartParkingService.vehicleExit(licenceNoPlate);
        return Map.of("fee", fee);
    }
}
