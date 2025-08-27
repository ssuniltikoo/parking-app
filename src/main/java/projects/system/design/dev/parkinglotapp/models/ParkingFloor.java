package projects.system.design.dev.parkinglotapp.models;


import lombok.Getter;
import lombok.Setter;
import projects.system.design.dev.parkinglotapp.models.enums.ParkingFloorStatus;

import java.util.List;

@Getter
@Setter
public class ParkingFloor extends BaseModel {
    private List<ParkingSlot> parkingSlots;
    private int floorNumber;
    private ParkingFloorStatus parkingFloorStatus;

}
