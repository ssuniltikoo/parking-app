package projects.system.design.dev.parkinglotapp.strategies;

import projects.system.design.dev.parkinglotapp.models.ParkingLot;
import projects.system.design.dev.parkinglotapp.models.ParkingSlot;
import projects.system.design.dev.parkinglotapp.models.enums.VehicleType;

public interface SlotAssignmentStrategy {
     ParkingSlot assignSlot(ParkingLot parkingLot, VehicleType vehicleType);
}
