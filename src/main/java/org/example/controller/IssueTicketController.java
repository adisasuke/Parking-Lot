package org.example.controller;

import org.example.dtos.RequestDtoIssueTicket;
import org.example.dtos.ResponseDtoIssueTicket;
import org.example.factory.SpotAssignmentStrategyFactory;
import org.example.models.*;
import org.example.repositories.GateRepository;
import org.example.repositories.VehicleRepository;
import org.example.service.IssueTicketService;
import org.example.strategies.RandomSpotStrategy;
import org.example.strategies.SpotAssignmentStrategy;

public class IssueTicketController {


    private IssueTicketService issueTicketService;

    public IssueTicketController(IssueTicketService issueTicketService) {
        this.issueTicketService = issueTicketService;
    }



    public ResponseDtoIssueTicket issueTicket(RequestDtoIssueTicket requestDtoIssueTicket) {

        long vechicleNumber = requestDtoIssueTicket.getVechicleNumber();
        VEHICLETYPE vehicleType = requestDtoIssueTicket.getVehicleType();
        String ownerName = requestDtoIssueTicket.getOwnerName();
        long gateId  = requestDtoIssueTicket.getGateId();

        ResponseDtoIssueTicket responseDtoIssueTicket = new ResponseDtoIssueTicket();
        Ticket ticket;
        try {
            ticket = issueTicketService.issueTicket(vechicleNumber, vehicleType, ownerName, gateId);
        }
        catch (Exception e) {
            System.out.println("Issue Ticket Error");
            System.out.println(e);
            responseDtoIssueTicket.setIssueticketresponsestatus(ISSUETICKETRESPONSESTATUS.FAILURE);
            return responseDtoIssueTicket;
        }
        responseDtoIssueTicket.setTicket(ticket);
        return responseDtoIssueTicket;

    }
}
