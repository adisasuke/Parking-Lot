package org.example.models;

import java.util.List;

public class Spot extends BaseModel{

    List<VEHICLETYPE> vehicleTypes;
    Vehicle vehicle;
    SPOTSTATUS spotstatus;

    public Spot(List<VEHICLETYPE> vehicleTypes,Vehicle vehicle, SPOTSTATUS spotstatus) {
        this.vehicleTypes = vehicleTypes;
        this.spotstatus = spotstatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<VEHICLETYPE> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VEHICLETYPE> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public SPOTSTATUS getSpotstatus() {
        return spotstatus;
    }

    public void setSpotstatus(SPOTSTATUS spotstatus) {
        this.spotstatus = spotstatus;
    }
}
