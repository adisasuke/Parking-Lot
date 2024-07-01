package org.example.strategies;

import org.example.models.ParkingLot;
import org.example.models.Spot;
import org.example.models.Vehicle;

public interface SpotAssignmentStrategy {
    Spot assignSpot(ParkingLot parkingLot, Vehicle vehicle);
}
