package com.parkinglot.ParkingLotSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private int floor;
    private String spotNo;
    private int size;
    private boolean isAvailabel;

    public ParkingSpot(Long id, int floor, String spotNo, int size, boolean isAvailabel) {
        this.id = id;
        this.floor = floor;
        this.spotNo = spotNo;
        this.size = size;
        this.isAvailabel = isAvailabel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(String spotNo) {
        this.spotNo = spotNo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isAvailabel() {
        return isAvailabel;
    }

    public void setAvailabel(boolean availabel) {
        isAvailabel = availabel;
    }
}
