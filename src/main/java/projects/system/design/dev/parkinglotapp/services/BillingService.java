package projects.system.design.dev.parkinglotapp.services;

import org.springframework.stereotype.Service;
import projects.system.design.dev.parkinglotapp.models.Bill;
import projects.system.design.dev.parkinglotapp.models.Gate;
import projects.system.design.dev.parkinglotapp.models.Ticket;
import projects.system.design.dev.parkinglotapp.services.interfaces.BillingSystem;

@Service
public class BillingService implements BillingSystem {
    @Override
    public Bill generateBill(Ticket ticket, Gate exitGate) {
        //ticket.getEntryGate().get
        return null;
    }
}
