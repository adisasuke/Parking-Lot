package org.example;

import org.example.controller.IssueTicketController;
import org.example.dtos.RequestDtoIssueTicket;
import org.example.dtos.ResponseDtoIssueTicket;
import org.example.models.*;
import org.example.repositories.GateRepository;
import org.example.repositories.ParkingLotRepository;
import org.example.repositories.VehicleRepository;
import org.example.service.IssueTicketService;
import org.example.strategies.SpotAssignmentStrategy;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {



    private static void create(ParkingLotRepository parkingLotRepository, GateRepository gateRepository)
    {
        Operator operator1 = new Operator("Bob", 1);
        Operator operator2 = new Operator("Alice", 2);
        Gate gate1 = new Gate(operator1);
        Gate gate2 = new Gate(operator1);
        Gate gate3 = new Gate(operator2);
        Gate gate4 = new Gate(operator2);
        List<Gate> gates = new ArrayList<>();
        gates.add(gate1);
        gates.add(gate2);
        gates.add(gate3);
        gates.add(gate4);
        gateRepository.save(gate1);
        gateRepository.save(gate2);
        gateRepository.save(gate3);
        gateRepository.save(gate4);




        List<VEHICLETYPE> vehicleTypes = new ArrayList<>();
        vehicleTypes.add(VEHICLETYPE.BIKE);
        vehicleTypes.add(VEHICLETYPE.CAR);
        vehicleTypes.add(VEHICLETYPE.AUTO);

        Spot spot1 = new Spot(vehicleTypes, null, SPOTSTATUS.EMPTY);
        Spot spot2 = new Spot(vehicleTypes, null, SPOTSTATUS.EMPTY);
        Spot spot3 = new Spot(vehicleTypes, null, SPOTSTATUS.EMPTY);
        List<Spot> spots1 = new ArrayList<>();
        spots1.add(spot1);
        spots1.add(spot2);
        spots1.add(spot3);


        Spot spot4 = new Spot(vehicleTypes, null, SPOTSTATUS.EMPTY);
        Spot spot5 = new Spot(vehicleTypes, null, SPOTSTATUS.EMPTY);
        Spot spot6 = new Spot(vehicleTypes, null, SPOTSTATUS.EMPTY);
        List<Spot> spots2 = new ArrayList<>();
        spots2.add(spot4);
        spots2.add(spot5);
        spots2.add(spot6);


        Spot spot7 = new Spot(vehicleTypes, null, SPOTSTATUS.EMPTY);
        Spot spot8 = new Spot(vehicleTypes, null, SPOTSTATUS.EMPTY);
        Spot spot9 = new Spot(vehicleTypes, null, SPOTSTATUS.EMPTY);
        List<Spot> spots3 = new ArrayList<>();
        spots3.add(spot7);
        spots3.add(spot8);
        spots3.add(spot9);

        ParkingFloor parkingFloor1 = new ParkingFloor(1,spots1);
        ParkingFloor parkingFloor2 = new ParkingFloor(2,spots2);
        ParkingFloor parkingFloor3 = new ParkingFloor(3,spots3);

        List<ParkingFloor> parkingFloors = new ArrayList<>();
        parkingFloors.add(parkingFloor1);
        parkingFloors.add(parkingFloor2);
        parkingFloors.add(parkingFloor3);

        ParkingLot parkingLot = new ParkingLot(gates, vehicleTypes, parkingFloors);
        parkingLotRepository.save(parkingLot);


    }


    public static void main(String[] args) {



        GateRepository gateRepository  = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

        SPOTASSIGNMENTSTRATEGY spotAssignmentStrategy = SPOTASSIGNMENTSTRATEGY.RANDOMSPOTASSIGNMENT;

        create(parkingLotRepository, gateRepository);



        IssueTicketService issueTicketService = new IssueTicketService(gateRepository,parkingLotRepository , vehicleRepository, spotAssignmentStrategy);


        IssueTicketController issueTicketController = new IssueTicketController(issueTicketService);

        RequestDtoIssueTicket requestDtoIssueTicket = new RequestDtoIssueTicket();

        requestDtoIssueTicket.setVechicleNumber(123);
        requestDtoIssueTicket.setVehicleType(VEHICLETYPE.CAR);
        requestDtoIssueTicket.setOwnerName("Aditya");
        requestDtoIssueTicket.setGateId(1);

        ResponseDtoIssueTicket responseDtoIssueTicket = issueTicketController.issueTicket(requestDtoIssueTicket);
        if(responseDtoIssueTicket.getIssueticketresponsestatus()!=ISSUETICKETRESPONSESTATUS.FAILURE)
        {
            System.out.println("Ticket Issue");
            System.out.println("Operator is : " + responseDtoIssueTicket.getTicket().getOperator().getName());
        }
        else
        {
            System.out.println("Ticket Issue failed");
        }
    }
}