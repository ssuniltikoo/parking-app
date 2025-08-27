package projects.system.design.dev.parkinglotapp.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import projects.system.design.dev.parkinglotapp.factory.SlotAssignmentStrategyFactory;
import projects.system.design.dev.parkinglotapp.models.ParkingFloor;
import projects.system.design.dev.parkinglotapp.models.ParkingLot;
import projects.system.design.dev.parkinglotapp.models.ParkingSlot;
import projects.system.design.dev.parkinglotapp.models.enums.ParkingFloorStatus;
import projects.system.design.dev.parkinglotapp.models.enums.ParkingSlotStatus;
import projects.system.design.dev.parkinglotapp.models.enums.VehicleType;
import projects.system.design.dev.parkinglotapp.strategies.SlotAssignmentStrategyType;

import java.util.*;

@Component
public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLots;
    private long id;

    public ParkingLotRepository(){
        parkingLots = new HashMap<Long, ParkingLot>();
        id=0L;
    }

    public Optional<ParkingLot> getParkingLot(long parkingLotId) {
        if(parkingLots.containsKey(parkingLotId)){
            return Optional.of(parkingLots.get(parkingLotId));
        }
        return Optional.empty();
    }

    @PostConstruct
    public void LoadData(){


        ParkingSlot slot1 = new ParkingSlot();
        slot1.setId(1L);
        slot1.setCreatedDate(new Date());
        slot1.setParkingSlotStatus(ParkingSlotStatus.EMPTY);
        slot1.setParkingSlotNumber("1-1-A-1");
        slot1.setAllowedVehicleType(VehicleType.CAR);
        ParkingSlot slot2 = new ParkingSlot();
        slot2.setId(2L);
        slot2.setCreatedDate(new Date());
        slot2.setParkingSlotStatus(ParkingSlotStatus.EMPTY);
        slot2.setParkingSlotNumber("1-1-A-2");
        slot2.setAllowedVehicleType(VehicleType.TRUCK);

        List<ParkingSlot> slotList = new ArrayList<>();
        slotList.add(slot1);
        slotList.add(slot2);

        ParkingFloor floor1 = new ParkingFloor();
        floor1.setId(1L);
        floor1.setCreatedDate(new Date());
        floor1.setFloorNumber(1);
        floor1.setParkingFloorStatus(ParkingFloorStatus.AVAILABLE);


        floor1.setParkingSlots(slotList);

        List<ParkingFloor> parkingList = new ArrayList<>();
        parkingList.add(floor1);

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(++id);
        parkingLot.setCreatedDate(new Date());
        parkingLot.setParkingSlotStatus(ParkingSlotStatus.EMPTY);

        parkingLot.setParkingFloors(parkingList);
        Set<VehicleType> vehilesTypes = new HashSet<>();
        vehilesTypes.add(VehicleType.CAR);
        vehilesTypes.add(VehicleType.TRUCK);
        vehilesTypes.add(VehicleType.BIKE);
        parkingLot.setAllowedVehicleTypes(vehilesTypes);
        parkingLot.
                setSlotAssignmentStrategy(SlotAssignmentStrategyFactory
                        .getSlotAssignmentStrategy(SlotAssignmentStrategyType.NEAREST));


        parkingLots.put(parkingLot.getId(), parkingLot);
    }



}
