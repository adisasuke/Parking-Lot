package org.example;

import org.example.controller.IssueTicketController;
import org.example.models.SPOTASSIGNMENTSTRATEGY;
import org.example.repositories.GateRepository;
import org.example.repositories.ParkingLotRepository;
import org.example.repositories.VehicleRepository;
import org.example.service.IssueTicketService;
import org.example.strategies.SpotAssignmentStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        GateRepository gateRepository  = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        SPOTASSIGNMENTSTRATEGY spotAssignmentStrategy = SPOTASSIGNMENTSTRATEGY.RANDOMSPOTASSIGNMENT;

        IssueTicketService issueTicketService = new IssueTicketService(gateRepository,parkingLotRepository , vehicleRepository, spotAssignmentStrategy);


        IssueTicketController issueTicketController = new IssueTicketController(issueTicketService);

    }
}