package projects.system.design.dev.parkinglotapp.services.interfaces;

import projects.system.design.dev.parkinglotapp.models.Bill;
import projects.system.design.dev.parkinglotapp.models.enums.PaymentMode;
import projects.system.design.dev.parkinglotapp.models.enums.PaymentStatus;

public interface PaymentProcessor{
    PaymentStatus processPayment(Bill bill, PaymentMode mode, double amount);
}

