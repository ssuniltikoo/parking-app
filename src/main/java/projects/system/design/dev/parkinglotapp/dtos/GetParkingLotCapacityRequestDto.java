package projects.system.design.dev.parkinglotapp.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetParkingLotCapacityRequestDto {
    private long parkingLotId;
    private List<Long> parkingFloorIds;

    private List<String> vehicleTypes;

}

