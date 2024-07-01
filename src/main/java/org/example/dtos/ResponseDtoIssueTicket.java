package org.example.dtos;
import org.example.models.ISSUETICKETRESPONSESTATUS;
import org.example.models.Ticket;


public class ResponseDtoIssueTicket {

    Ticket ticket;
    ISSUETICKETRESPONSESTATUS issueticketresponsestatus = ISSUETICKETRESPONSESTATUS.SUCCESS;

    public ISSUETICKETRESPONSESTATUS getIssueticketresponsestatus() {
        return issueticketresponsestatus;
    }

    public void setIssueticketresponsestatus(ISSUETICKETRESPONSESTATUS issueticketresponsestatus) {
        this.issueticketresponsestatus = issueticketresponsestatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }




}
