package projects.system.design.dev.parkinglotapp.services.interfaces;

import projects.system.design.dev.parkinglotapp.models.ParkingLot;
import projects.system.design.dev.parkinglotapp.models.enums.VehicleType;

public interface checkParkingAvailability {
    boolean isParkingAvailable(ParkingLot parkingLot, VehicleType vehicleType);
}
