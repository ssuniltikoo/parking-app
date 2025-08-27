package projects.system.design.dev.parkinglotapp.models;


import lombok.Getter;
import lombok.Setter;
import projects.system.design.dev.parkinglotapp.models.enums.ParkingSlotStatus;
import projects.system.design.dev.parkinglotapp.models.enums.VehicleType;



@Getter
@Setter
public class ParkingSlot extends BaseModel {
    private String parkingSlotNumber;
    private ParkingSlotStatus parkingSlotStatus;
    private VehicleType allowedVehicleType;
    private Vehicle occupyingVehicle;

    public boolean canPark(Vehicle vehicle) {
        return parkingSlotStatus.equals(ParkingSlotStatus.EMPTY)
                && allowedVehicleType.equals(vehicle.getVehicleType());
    }

    public void park(Vehicle vehicle) {
        if(!canPark(vehicle)) {
            throw new IllegalStateException("Can't park vehicle " + vehicle.getVehicleType() + " in this slot");
        }

        this.occupyingVehicle = vehicle;
        this.parkingSlotStatus = ParkingSlotStatus.FILLED;
    }

    public void removeVehicle(Vehicle vehicle) {
        this.occupyingVehicle = null;
        this.parkingSlotStatus = ParkingSlotStatus.EMPTY;
    }



}
