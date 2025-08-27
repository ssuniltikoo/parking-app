package projects.system.design.dev.parkinglotapp.models;

import lombok.Getter;
import lombok.Setter;
import projects.system.design.dev.parkinglotapp.models.enums.BillStatus;
import projects.system.design.dev.parkinglotapp.strategies.ParkingFeesCalculationStrategy;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Bill extends BaseModel{
    private Ticket ticket;
    private Gate exitGate;
    private double amount;
    private Date exitTime;
    private List<Payment> payments;
    private BillStatus billStatus;
    private ParkingFeesCalculationStrategy parkingFeesCalculationStrategy;
}
