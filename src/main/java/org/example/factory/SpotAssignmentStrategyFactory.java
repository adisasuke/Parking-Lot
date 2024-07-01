package org.example.factory;

import org.example.models.SPOTASSIGNMENTSTRATEGY;
import org.example.strategies.RandomSpotStrategy;
import org.example.strategies.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {

    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SPOTASSIGNMENTSTRATEGY spotassignmentstrategy)
    {
        return new RandomSpotStrategy();
    }
}
