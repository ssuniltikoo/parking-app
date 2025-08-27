package projects.system.design.dev.parkinglotapp.models;


import lombok.Getter;
import lombok.Setter;
import projects.system.design.dev.parkinglotapp.models.enums.VehicleType;

@Getter
@Setter
public class Vehicle extends BaseModel{
    private String vehicleNumber;
    private String ownerName;
    private VehicleType vehicleType;
}
