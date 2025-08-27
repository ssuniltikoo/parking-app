package projects.system.design.dev.parkinglotapp.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Operator extends BaseModel{
    private String operatorName;
    private Gate gate;

}
