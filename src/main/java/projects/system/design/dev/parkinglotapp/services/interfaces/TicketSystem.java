package projects.system.design.dev.parkinglotapp.services.interfaces;

import projects.system.design.dev.parkinglotapp.models.Long;
import projects.system.design.dev.parkinglotapp.models.Ticket;
import projects.system.design.dev.parkinglotapp.models.enums.VehicleType;

public interface TicketSystem {
    Ticket issueTicket(VehicleType type, Long entryGateId, String vehicleNumber);
}
