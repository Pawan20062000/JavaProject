package com.parkinglot.ParkingLotSystem.entity;

import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licenceNoPlate;

    @ManyToOne
    private VehicleType type;

    public Vehicle(){

    }

    public Vehicle(Long id, String licenceNoPlate, VehicleType type) {
        this.id = id;
        this.licenceNoPlate = licenceNoPlate;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicenceNoPlate() {
        return licenceNoPlate;
    }

    public void setLicenceNoPlate(String licenceNoPlate) {
        this.licenceNoPlate = licenceNoPlate;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
