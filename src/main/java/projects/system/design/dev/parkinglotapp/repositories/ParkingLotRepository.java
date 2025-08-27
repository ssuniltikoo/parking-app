package projects.system.design.dev.parkinglotapp.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import projects.system.design.dev.parkinglotapp.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLots;


    public ParkingLotRepository(){
        parkingLots = new HashMap<Long, ParkingLot>();
    }

    public Optional<ParkingLot> getParkingLot(long parkingLotId) {
        if(parkingLots.containsKey(parkingLotId)){
            return Optional.of(parkingLots.get(parkingLotId));
        }
        return Optional.empty();
    }



}
