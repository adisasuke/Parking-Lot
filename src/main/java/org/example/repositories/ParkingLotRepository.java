package org.example.repositories;

import org.example.models.Gate;
import org.example.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLots = new HashMap<>();
    private int id = 0;

    public ParkingLot findByGate(Gate gate) {
        for(ParkingLot parkingLot: parkingLots.values()) {
            if(parkingLot.getGates().contains(gate)) {
                return parkingLot;
            }
        }

        return null;
    }

    public ParkingLot save(ParkingLot parkingLot) {
        id++;
        parkingLot.setId(id);
        parkingLots.put(parkingLot.getId(), parkingLot);
        return parkingLot;
    }

}
