package projects.system.design.dev.parkinglotapp.services;

import projects.system.design.dev.parkinglotapp.models.ParkingFloor;
import projects.system.design.dev.parkinglotapp.models.ParkingLot;
import projects.system.design.dev.parkinglotapp.models.ParkingSlot;
import projects.system.design.dev.parkinglotapp.models.enums.ParkingFloorStatus;
import projects.system.design.dev.parkinglotapp.models.enums.ParkingSlotStatus;
import projects.system.design.dev.parkinglotapp.models.enums.VehicleType;
import projects.system.design.dev.parkinglotapp.services.interfaces.checkParkingAvailability;

import java.util.List;

public class ParkingLotAvailablityChecker implements checkParkingAvailability {
    @Override
    public boolean isParkingAvailable(ParkingLot parkingLot, VehicleType vehicleType) {
          List<ParkingFloor> floors = parkingLot.getParkingFloors().stream()
                  .filter(parkingFloor -> parkingFloor.getParkingFloorStatus()
                          .equals(ParkingFloorStatus.AVAILABLE)
          ).toList();

          for(ParkingFloor floor : floors) {
             List<ParkingSlot> slots = floor.getParkingSlots().stream()
                      .filter(slot->slot.getParkingSlotStatus().equals(ParkingSlotStatus.EMPTY))
                     .filter(slot->slot.getAllowedVehicleType().equals(vehicleType))
                     .toList();
             if(!slots.isEmpty()){
                 return true;
             }
          }
          return false;
    }
}
