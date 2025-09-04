package projects.system.design.dev.parkinglotapp.services;

import org.springframework.stereotype.Service;
import projects.system.design.dev.parkinglotapp.exception.InvalidParkingLotException;
import projects.system.design.dev.parkinglotapp.models.ParkingFloor;
import projects.system.design.dev.parkinglotapp.models.enums.VehicleType;
import projects.system.design.dev.parkinglotapp.repositories.ParkingLotRepository;

import java.util.List;
import java.util.Map;

@Service
public class ParkingLotService {

    private final ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public Map<ParkingFloor, Map<String, Integer>> getParkingLotCapacity(long parkingLotId,
         List<Long> parkingFloors, List<VehicleType> vehicleTypes) throws InvalidParkingLotException
    {
        return null;
    }

}
