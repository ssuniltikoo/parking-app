package projects.system.design.dev.parkinglotapp.services;

import org.springframework.stereotype.Service;
import projects.system.design.dev.parkinglotapp.exception.GateNotFoundException;
import projects.system.design.dev.parkinglotapp.models.*;
import projects.system.design.dev.parkinglotapp.models.Long;
import projects.system.design.dev.parkinglotapp.models.enums.ParkingSlotStatus;
import projects.system.design.dev.parkinglotapp.models.enums.VehicleType;
import projects.system.design.dev.parkinglotapp.repositories.GateRepository;
import projects.system.design.dev.parkinglotapp.repositories.ParkingLotRepository;
import projects.system.design.dev.parkinglotapp.repositories.TicketRepository;
import projects.system.design.dev.parkinglotapp.repositories.VehicleRepository;
import projects.system.design.dev.parkinglotapp.services.interfaces.TicketSystem;

import java.util.Date;
import java.util.Optional;

@Service
public class TicketService  implements TicketSystem {
    private static final int parkingLotId = 1;
    private final TicketRepository ticketRepository;
    private final GateRepository gateRepository;
    private final VehicleRepository   vehicleRepository;
    private final ParkingLotRepository parkingLotRepository;

    public TicketService( TicketRepository ticketRepository, GateRepository gateRepository, VehicleRepository vehicleRepository
    , ParkingLotRepository parkingLotRepository) {
        this.ticketRepository = ticketRepository;
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket issueTicket(java.lang.Long gateId, String licencePlateNumber, String ownerName, VehicleType vehicleType) throws GateNotFoundException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
       Optional<Long> gate = gateRepository.findGateByGateId(gateId);
        if(gate.isEmpty()){
            throw new GateNotFoundException("Please enter valid gate number");
        }
        ticket.setEntryGate(gate.get());

        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByVehicleNumber(licencePlateNumber);
        Vehicle vehicleInfo = null;
        if(optionalVehicle.isEmpty()){
            vehicleInfo = new Vehicle();
            vehicleInfo.setVehicleNumber(licencePlateNumber);
            vehicleInfo.setOwnerName(ownerName);
            vehicleInfo.setVehicleType(vehicleType);
            vehicleRepository.save(vehicleInfo);
        }else{
            vehicleInfo = optionalVehicle.get();
        }
        ticket.setVehicle(vehicleInfo);

        Optional<ParkingLot> optionalParkingLot  = parkingLotRepository.getParkingLot(parkingLotId);
        if(optionalParkingLot.isEmpty()){
            throw new RuntimeException("Invalid Parking Lot");
        }

        ParkingLot parkingLot = optionalParkingLot.get();

       ParkingSlot slot =  parkingLot.
               getSlotAssignmentStrategy()
               .assignSlot(parkingLot,vehicleType);
       slot.setParkingSlotStatus(ParkingSlotStatus.FILLED);
       ticket.setParkingSlot(slot);
       Ticket t =  ticketRepository.save(ticket);
        return t;
    }

    @Override
    public Ticket issueTicket(VehicleType type, Long entryGate, String licencePlateNumber) {

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        Optional<Long> gate = gateRepository.findGateByGateId(entryGate.getId());
        if(gate.isEmpty()){
            throw new RuntimeException("Please enter valid gate number");
        }
        ticket.setEntryGate(gate.get());

        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByVehicleNumber(licencePlateNumber);
        Vehicle vehicleInfo = null;
        if(optionalVehicle.isEmpty()){
            vehicleInfo = new Vehicle();
            vehicleInfo.setVehicleNumber(licencePlateNumber);
            //vehicleInfo.setOwnerName(ownerName);
            vehicleInfo.setVehicleType(type);
            vehicleRepository.save(vehicleInfo);
        }else{
            vehicleInfo = optionalVehicle.get();
        }
        ticket.setVehicle(vehicleInfo);

        Optional<ParkingLot> optionalParkingLot  = parkingLotRepository.getParkingLot(parkingLotId);
        if(optionalParkingLot.isEmpty()){
            throw new RuntimeException("Invalid Parking Lot");
        }

        ParkingLot parkingLot = optionalParkingLot.get();

        ParkingSlot slot =  parkingLot.
                getSlotAssignmentStrategy()
                .assignSlot(parkingLot,type);
        slot.setParkingSlotStatus(ParkingSlotStatus.FILLED);
        ticket.setParkingSlot(slot);
        Ticket t =  ticketRepository.save(ticket);
        return t;
    }
}
