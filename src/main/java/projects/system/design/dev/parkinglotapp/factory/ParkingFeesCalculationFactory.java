package projects.system.design.dev.parkinglotapp.factory;

import projects.system.design.dev.parkinglotapp.models.enums.VehicleType;
import projects.system.design.dev.parkinglotapp.strategies.BikeParkingFeesCalculation;
import projects.system.design.dev.parkinglotapp.strategies.CarParkingFeesCalculation;
import projects.system.design.dev.parkinglotapp.strategies.ParkingFeesCalculationStrategy;
import projects.system.design.dev.parkinglotapp.strategies.TruckParkingFeesCalculation;

public class ParkingFeesCalculationFactory{

    private ParkingFeesCalculationFactory(){}

    public static ParkingFeesCalculationStrategy getParkingFeesCalculationStrategy(VehicleType vehicleType){
        if(vehicleType.equals(VehicleType.CAR)){
            return new CarParkingFeesCalculation();
        }else  if(vehicleType.equals(VehicleType.BIKE)){
            return new BikeParkingFeesCalculation();
        }else  if(vehicleType.equals(VehicleType.TRUCK)){
            return new TruckParkingFeesCalculation();
        }else
            return    null;
    }
}
