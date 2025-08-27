package projects.system.design.dev.parkinglotapp.repositories;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import projects.system.design.dev.parkinglotapp.models.Ticket;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class TicketRepository {

    private Map<Long, Ticket> tickets;
    private Long id;
    public TicketRepository(){
        tickets = new HashMap<>();
        id = 0L;
    }

    Optional<Ticket> findTicketById(Long ticketId){
        return Optional.ofNullable(tickets.get(ticketId));
    }

   public Ticket save(Ticket ticket){
        ticket.setId(++id);
        ticket.setTicketNumber(id.toString()+new Date().toString());
        ticket.setCreatedDate(new Date());
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }

}
