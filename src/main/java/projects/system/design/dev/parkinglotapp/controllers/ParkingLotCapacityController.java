package projects.system.design.dev.parkinglotapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.system.design.dev.parkinglotapp.dtos.GetParkingLotCapacityRequestDto;
import projects.system.design.dev.parkinglotapp.dtos.GetParkingLotCapacityResponseDto;
import projects.system.design.dev.parkinglotapp.exception.InvalidParkingLotException;
import projects.system.design.dev.parkinglotapp.models.enums.VehicleType;
import projects.system.design.dev.parkinglotapp.services.ParkingLotService;

@RestController
public class ParkingLotCapacityController {

    private ParkingLotService parkingLotService;

    public ParkingLotCapacityController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping("/capacity")
    public ResponseEntity<GetParkingLotCapacityResponseDto> getParkingLotCapacity(GetParkingLotCapacityRequestDto request) {
        GetParkingLotCapacityResponseDto responseDto = new GetParkingLotCapacityResponseDto();
        try{
            parkingLotService.getParkingLotCapacity(request.getParkingLotId(),
                    request.getParkingFloorIds(),request.getVehicleTypes().stream()
                            .map(VehicleType::valueOf).toList());
        }catch(InvalidParkingLotException ex){
            return null;
        }
        return null;

    }

}
