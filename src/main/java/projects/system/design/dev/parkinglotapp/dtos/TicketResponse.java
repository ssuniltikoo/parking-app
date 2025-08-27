package projects.system.design.dev.parkinglotapp.dtos;


import lombok.Getter;
import lombok.Setter;
import projects.system.design.dev.parkinglotapp.models.Ticket;

@Getter
@Setter
public class TicketResponse {
    private Ticket ticket;
    private TicketResponseStatus status;

}
