package org.example.models;

import java.util.List;

public class ParkingFloor extends BaseModel{
    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public ParkingFloor(int floorNumber, List<Spot> spots) {
        this.floorNumber = floorNumber;
        this.spots = spots;
    }

    private int floorNumber;
    List<Spot> spots;
}
