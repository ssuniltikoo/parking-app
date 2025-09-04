package projects.system.design.dev.parkinglotapp.dtos;

import projects.system.design.dev.parkinglotapp.models.ParkingFloor;

import java.util.Map;

public class GetParkingLotCapacityResponseDto {
    private Response response;

    private Map<ParkingFloor, Map<String, Integer>> capacityMap;
}
