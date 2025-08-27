package projects.system.design.dev.parkinglotapp.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import projects.system.design.dev.parkinglotapp.models.Gate;
import projects.system.design.dev.parkinglotapp.models.Operator;
import projects.system.design.dev.parkinglotapp.models.enums.GateStatus;
import projects.system.design.dev.parkinglotapp.models.enums.GateType;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class GateRepository {





    private Map<Long, Gate> gates ;
    private Long id;

    public GateRepository() {
        gates = new HashMap<>();
        id=0L;

    }

    public Gate save(Gate gate) {
        id=id+1;
        gates.put(id, gate);
        return gate;
    }

    @PostConstruct
    public void initializeData(){
        long gateId =1L;

        Gate g1 = new Gate();
        g1.setId(gateId++);
        g1.setGateStatus(GateStatus.OPEN);
        g1.setGateNumber("ENTRY-1");
        g1.setGateType(GateType.ENTRY);
        g1.setCreatedDate(new Date());
        Operator op = new Operator();
        op.setId(1L);
        op.setGate(g1);
        gates.put(++id, g1);
        Gate g2 = new Gate();
        g2.setId(gateId++);
        g2.setGateStatus(GateStatus.OPEN);
        g2.setGateNumber("ENTRY-2");
        g2.setGateType(GateType.ENTRY);
        g2.setCreatedDate(new Date());
        Operator op2 = new Operator();
        op2.setId(2L);
        op2.setGate(g1);



        gates.put(++id, g2);
    }


   public  Optional<Gate> findGateByGateId(Long gateId){
      if(gates.containsKey(gateId)){
          return Optional.of(gates.get(gateId));
      }
        return Optional.empty();
    }



}


// db

// orm