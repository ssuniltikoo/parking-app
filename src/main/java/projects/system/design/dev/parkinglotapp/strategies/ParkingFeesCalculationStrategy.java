package projects.system.design.dev.parkinglotapp.strategies;

import projects.system.design.dev.parkinglotapp.models.enums.VehicleType;

import java.util.Date;

public interface ParkingFeesCalculationStrategy {
    Integer calculateParkingFees( int duration );

    default Integer CalculateParkingFees(Date entryTime, Date exitTime){
        long timeDiff = exitTime.getTime() - entryTime.getTime();
        int durationInHours = (int) (timeDiff / (1000 * 60 * 60));
        return calculateParkingFees(durationInHours);
    }
}
