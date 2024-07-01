package org.example.repositories;

import org.example.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {

    private Map<Long, Gate> gates = new HashMap<>();// Gateid and Gate
    private static int gateNumber = 0;
    public Optional<Gate> findById(long GateId)
    {
        if(gates.containsKey(GateId))
        {
            return Optional.of(gates.get(GateId));
        }
        return Optional.empty();
    }

    public Gate save(Gate gate)
    {
        gateNumber++;
        gate.setId(gateNumber);
        gates.put(gate.getId(), gate);
        return gate;
    }

}
