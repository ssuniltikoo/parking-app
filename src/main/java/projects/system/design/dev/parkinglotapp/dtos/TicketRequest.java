package projects.system.design.dev.parkinglotapp.dtos;

import lombok.Getter;
import lombok.Setter;
import projects.system.design.dev.parkinglotapp.models.enums.VehicleType;

@Getter
@Setter
public class TicketRequest {
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String ownerName;
    private Long gateId;
    //private Long parkingLotId;
}
