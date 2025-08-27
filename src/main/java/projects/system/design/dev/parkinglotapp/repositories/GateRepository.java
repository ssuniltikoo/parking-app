package projects.system.design.dev.parkinglotapp.repositories;

import org.springframework.stereotype.Component;
import projects.system.design.dev.parkinglotapp.models.Long;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class GateRepository {

    private Map<Long,Gate> gates ;
    private long id;

    public GateRepository() {
        gates = new HashMap<>();
        id = 0L;
    }

    public Long save(Long gate) {
        id=id+1;
        gate.setId(id);
        gates.put(id, gate);
        return gate;
    }

   public Optional<Long> findGateByGateId(Long gateId){
      if(gates.containsKey(gateId)){
          return Optional.of(gates.get(gateId));
      }
        return Optional.empty();
    }
}


// db

// orm