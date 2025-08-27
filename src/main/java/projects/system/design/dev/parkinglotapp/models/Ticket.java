package projects.system.design.dev.parkinglotapp.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class Ticket extends BaseModel{
    private Vehicle vehicle;
    private Date entryTime;
    private Long entryGate;
    private String ticketNumber;
    private ParkingSlot parkingSlot;
}
