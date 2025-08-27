package projects.system.design.dev.parkinglotapp.models;


import lombok.Getter;
import lombok.Setter;
import projects.system.design.dev.parkinglotapp.models.enums.GateStatus;
import projects.system.design.dev.parkinglotapp.models.enums.GateType;

@Getter
@Setter
public class Gate extends BaseModel {
    private String GateNumber;
    private GateStatus gateStatus;
    private GateType gateType;
    private Operator currentOperator;

}
