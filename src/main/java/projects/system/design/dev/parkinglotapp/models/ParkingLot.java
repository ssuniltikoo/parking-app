package projects.system.design.dev.parkinglotapp.models;

import lombok.Getter;
import lombok.Setter;
import projects.system.design.dev.parkinglotapp.models.enums.ParkingSlotStatus;
import projects.system.design.dev.parkinglotapp.models.enums.VehicleType;
import projects.system.design.dev.parkinglotapp.services.interfaces.checkParkingAvailability;
import projects.system.design.dev.parkinglotapp.strategies.SlotAssignmentStrategy;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class ParkingLot  extends BaseModel{
    private List<ParkingFloor> parkingFloors;
    private List<Long> entryGates;
    private List<Long> exitGates;
    private ParkingSlotStatus parkingSlotStatus;
    private Set<VehicleType> allowedVehicleTypes;
    private Map<VehicleType,Integer> capacityByVehicleType;
    private SlotAssignmentStrategy slotAssignmentStrategy;
    private checkParkingAvailability parkingAvailabilityChecker;

    public boolean hasCapacityFor(VehicleType vehicleType) {
        int occupiedSlots = countOccupiedSlots(vehicleType);
        return occupiedSlots < capacityByVehicleType.getOrDefault(vehicleType, 0);
    }
//
    private int countOccupiedSlots(VehicleType vehicleType) {
    int count = 0;
    for (ParkingFloor floor : parkingFloors)
    {
        for (ParkingSlot slot : floor.getParkingSlots()) {
            if (slot.getAllowedVehicleType().equals(vehicleType) &&
                    slot.getParkingSlotStatus() == ParkingSlotStatus.FILLED)
            { count++;
            }
        }
    }
    return count;
    }

}
