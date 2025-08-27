package projects.system.design.dev.parkinglotapp.services;

import projects.system.design.dev.parkinglotapp.models.Bill;
import projects.system.design.dev.parkinglotapp.models.enums.PaymentMode;
import projects.system.design.dev.parkinglotapp.models.enums.PaymentStatus;
import projects.system.design.dev.parkinglotapp.services.interfaces.PaymentProcessor;

public class RazorPayIntegration implements PaymentProcessor {
    @Override
    public PaymentStatus processPayment(Bill bill, PaymentMode mode, double amount){
        //CallRazorPayAPI() // // dummy code here integratoon with razor pay
        if(true)
            return PaymentStatus.SUCCESS;
        else
            return PaymentStatus.FAILURE;
    }
}
