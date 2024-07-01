package org.example.service;

import org.example.exception.InvalidGateNumber;
import org.example.exception.NoFreeSpace;
import org.example.factory.SpotAssignmentStrategyFactory;
import org.example.models.*;
import org.example.repositories.GateRepository;
import org.example.repositories.ParkingLotRepository;
import org.example.repositories.VehicleRepository;
import org.example.strategies.SpotAssignmentStrategy;

import java.time.LocalDateTime;
import java.util.Optional;


//LocalDateTime entryTime;
//Spot spot;
//Vehicle vehicle;
//Gate gate;
//Operator operator;



public class IssueTicketService {

    private SPOTASSIGNMENTSTRATEGY spotAssignmentStrategy;
    private final SpotAssignmentStrategy random;
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;

    public IssueTicketService(GateRepository gateRepository,ParkingLotRepository parkingLotRepository, VehicleRepository vehicleRepository, SPOTASSIGNMENTSTRATEGY spotAssignmentStrategy) {
        this.gateRepository = gateRepository;
        this.vehicleRepository  = vehicleRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepository  = parkingLotRepository;
        random = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(spotAssignmentStrategy);
    }



    public Ticket issueTicket(long vechicleNumber,VEHICLETYPE vehicleType, String ownerName, long gateId) throws NoFreeSpace, InvalidGateNumber {



        Vehicle vehicle;
        Optional<Vehicle> vechicle_db = vehicleRepository.findByNumber(vechicleNumber);
        if(vechicle_db.isEmpty())
        {
            vehicle = new Vehicle();
            vehicle.setVechicleNumber(vechicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnerName(ownerName);
            vehicle = vehicleRepository.save(vehicle);
        }
        else{
            vehicle = vechicle_db.get();
        }


        Ticket ticket = new Ticket();
        ticket.setEntryTime(LocalDateTime.now());

        ticket.setVehicle(vehicle);

        Optional<Gate> gate = gateRepository.findById(gateId);
        if(gate.isEmpty())
        {
            throw new InvalidGateNumber();
        }
        Gate readGate = gate.get();
        ticket.setGate(readGate);
        ticket.setOperator(readGate.getCurrentOperator());

        ParkingLot parkingLot = parkingLotRepository.findByGate(readGate);

        Spot spot = random.assignSpot(parkingLot, vehicle);
        spot.setSpotstatus(SPOTSTATUS.FILLED);
        if(spot == null)
        {
            throw new NoFreeSpace();
        }

        ticket.setSpot(spot);

        return ticket;
    }
}
