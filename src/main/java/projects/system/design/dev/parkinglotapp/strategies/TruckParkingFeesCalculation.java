package projects.system.design.dev.parkinglotapp.strategies;

import lombok.Data;


public class TruckParkingFeesCalculation extends BaseParkingFeesCalculationBaseParkingFeesCal{

    private static final int  FIRST_TWO_HOURS_RATE = 50;
    private static final int TWO_TO_FOUR_HOURS_RATE = 60;
    private static final int FOUR_TO_SIX_HOURS_RATE = 65;
    private static final int AFTER_SIX_HOURS_RATE = 80;

    @Override
    public Integer calculateParkingFees(int duration) {
        return calculateFeesByDuration(duration,FIRST_TWO_HOURS_RATE,TWO_TO_FOUR_HOURS_RATE
                ,FOUR_TO_SIX_HOURS_RATE,AFTER_SIX_HOURS_RATE);
    }

}
