package org.example.strategies;

import org.example.models.*;

import java.util.List;

public class RandomSpotStrategy implements SpotAssignmentStrategy {

    //Todo : add assign spot strategy

    @Override
    public Spot assignSpot(ParkingLot parkingLot, Vehicle vehicle) {

        for(ParkingFloor floor : parkingLot.getParkingFloors()) {
            List<Spot> spots = floor.getSpots();
            for(Spot spot : spots) {
                if(spot.getSpotstatus()==SPOTSTATUS.EMPTY && spot.getVehicleTypes().contains(vehicle.getVehicleType())) {
                    spot.setVehicle(vehicle);
                    spot.setSpotstatus(SPOTSTATUS.FILLED);
                    return spot;
                }
            }
        }
        return null;

    }
}
