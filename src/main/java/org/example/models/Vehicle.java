package org.example.models;

public class Vehicle extends BaseModel{

    public long getVechicleNumber() {
        return vechicleNumber;
    }

    public void setVechicleNumber(long vechicleNumber) {
        this.vechicleNumber = vechicleNumber;
    }

    public VEHICLETYPE getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VEHICLETYPE vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    private long vechicleNumber;
    private VEHICLETYPE vehicleType;
    private String ownerName;

}
