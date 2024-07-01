package org.example.dtos;

import org.example.models.*;

import java.time.LocalDateTime;


public class RequestDtoIssueTicket {

    private long vechicleNumber;
    private VEHICLETYPE vehicleType;
    private String ownerName;
    long gateId;


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

    public long getGateId() {
        return gateId;
    }

    public void setGateId(long gateId) {
        this.gateId = gateId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
