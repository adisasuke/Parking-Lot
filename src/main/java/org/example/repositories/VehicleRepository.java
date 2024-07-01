package org.example.repositories;

import org.example.models.VEHICLETYPE;
import org.example.models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class VehicleRepository {

    private Map<Long, Vehicle> mp = new HashMap<>();
    private int id=0;

    public Optional<Vehicle> findByNumber(long vechicleNumber) {
        if(mp.containsKey(vechicleNumber)) {
            return Optional.of(mp.get(vechicleNumber));
        }
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle) {
        id++;
        vehicle.setId(id);
        mp.put(vehicle.getId(), vehicle);
        return vehicle;
    }

}
