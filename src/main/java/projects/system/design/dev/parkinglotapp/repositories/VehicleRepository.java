package projects.system.design.dev.parkinglotapp.repositories;

import jdk.jfr.Registered;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import projects.system.design.dev.parkinglotapp.models.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class VehicleRepository {

    private Map<String,Vehicle> vehicleMap;
    private Long counter =0L;

    public VehicleRepository() {
        vehicleMap = new HashMap<>();
    }

    public Vehicle save(Vehicle vehicle) {
        vehicle.setId(++counter);
        vehicleMap.put(vehicle.getVehicleNumber(),vehicle);
        return vehicle;
    }

    public Optional<Vehicle> findVehicleByVehicleNumber(String vehicleNumber){
        if(vehicleMap.containsKey(vehicleNumber)){
            return Optional.of(vehicleMap.get(vehicleNumber));
        }
        return Optional.empty();
    }
    public Optional<Vehicle> findVehicleById(Long vehicleId){
        List<Vehicle> vehicles = vehicleMap.values().stream().toList();
        for(Vehicle vehicle : vehicles){
            if(vehicle.getId().equals(vehicleId)){
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }

}
