package projects.system.design.dev.parkinglotapp.strategies;

import projects.system.design.dev.parkinglotapp.models.ParkingFloor;
import projects.system.design.dev.parkinglotapp.models.ParkingLot;
import projects.system.design.dev.parkinglotapp.models.ParkingSlot;
import projects.system.design.dev.parkinglotapp.models.enums.ParkingSlotStatus;
import projects.system.design.dev.parkinglotapp.models.enums.VehicleType;

public class RandomSlotAssignmentStrategy implements SlotAssignmentStrategy {

    @Override
    public ParkingSlot assignSlot(ParkingLot parkingLot, VehicleType vehicleType) {

        for(ParkingFloor floor: parkingLot.getParkingFloors()) {
            for(ParkingSlot slot:floor.getParkingSlots()){
                if(slot.getParkingSlotStatus().equals(ParkingSlotStatus.EMPTY) &&
                slot.getAllowedVehicleType().equals(vehicleType)) {
                    return slot;
                }
            }
        }


        return null;
    }
}
