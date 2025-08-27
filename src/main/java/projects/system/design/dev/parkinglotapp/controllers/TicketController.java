package projects.system.design.dev.parkinglotapp.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import projects.system.design.dev.parkinglotapp.dtos.TicketRequest;
import projects.system.design.dev.parkinglotapp.dtos.TicketResponse;
import projects.system.design.dev.parkinglotapp.dtos.TicketResponseStatus;
import projects.system.design.dev.parkinglotapp.models.Ticket;
import projects.system.design.dev.parkinglotapp.services.interfaces.TicketSystem;

@RestController
public class TicketController {

    private TicketSystem ticketSystem;

    public TicketController(TicketSystem ticketSystem) {
        this.ticketSystem = ticketSystem;
    }

    @PostMapping("/ticket")
    public TicketResponse issueTicket(@RequestBody TicketRequest request) {
        TicketResponse response = new TicketResponse();
        try{
//            ParkingAvailabilityChecker checker =
         Ticket t = ticketSystem.issueTicket(request.getVehicleType(),request.getGateId(),request.getVehicleType());
         response.setTicket(t);
         response.setStatus(TicketResponseStatus.SUCCESS);
         return response;
        }catch (Exception e) {
            response.setStatus(TicketResponseStatus.FAILURE);
        }
        return response;
    }

}
