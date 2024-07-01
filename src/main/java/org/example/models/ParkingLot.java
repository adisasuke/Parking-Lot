package org.example.models;
import java.util.*;

public class ParkingLot extends BaseModel{

    private List<Gate> gates;
    private List<ParkingFloor> parkingFloors;
    private List<VEHICLETYPE> vehicletypes;

    public ParkingLot(List<Gate> gates, List<VEHICLETYPE> vehicletypes, List<ParkingFloor> parkingFloors) {
        this.gates = gates;
        this.vehicletypes = vehicletypes;
        this.parkingFloors = parkingFloors;
    }



    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<VEHICLETYPE> getVehicletypes() {
        return vehicletypes;
    }

    public void setVehicletypes(List<VEHICLETYPE> vehicletypes) {
        this.vehicletypes = vehicletypes;
    }
}
