package projects.system.design.dev.parkinglotapp.services.interfaces;

import projects.system.design.dev.parkinglotapp.models.Bill;
import projects.system.design.dev.parkinglotapp.models.Gate;
import projects.system.design.dev.parkinglotapp.models.Ticket;

public interface BillingSystem {
    Bill generateBill(Ticket ticket, Gate exitGate);
}
